package com.example.group19.controller.Friends;

import com.example.group19.model.FriendRequest;
import com.example.group19.model.User;
import com.example.group19.repository.FriendRequestRepository;
import com.example.group19.repository.UserRepository;
import com.example.group19.service.GlobalUserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.*;

import static com.example.group19.model.FriendRequest.Status.*;

@Controller

public class FriendController {
    @Autowired
    GlobalUserIdService globalUserIdService;
    @Autowired
    UserRepository userRepo;

    @Autowired
    private FriendRequestRepository friendRequestRepo;

    @GetMapping("/friends")
    public String showFriendPage(@RequestParam(name = "searchQuery", required = false) String searchQuery,
                                 Model model) {
        User current = new User();
        int currentID = globalUserIdService.getCurrentID();
        current = userRepo.findById(currentID);
        List<User> friends = new ArrayList<>(current.getFriends());
        List<User> friendsLead = new ArrayList<>(current.getFriends());
        friendsLead.add(current);
        friendsLead.sort(Comparator.comparingInt(user -> user.getCoursesCompleted()));
        Collections.reverse(friendsLead);

        List<FriendRequest> friendRequests = friendRequestRepo.findByReceiverAndStatus(current, PENDING);
        List<FriendRequest> sentRequests = friendRequestRepo.findBySenderAndStatus(current, PENDING);

        model.addAttribute("friendRequests", friendRequests);
        model.addAttribute("sent", sentRequests);
        model.addAttribute("userID", currentID);
        model.addAttribute("currentUser", current);
        model.addAttribute("friends",friends);
        model.addAttribute("friendsLead",friendsLead);


        return "Friends/friends";
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam("username") String username, Model model) {
        List<User> searchResults = userRepo.findByUsernameContainingIgnoreCase(username);
        model.addAttribute("searchResults", searchResults);
        User current = new User();
        int currentID = globalUserIdService.getCurrentID();
        model.addAttribute("userID", currentID);
        return "Friends/search";
    }

    @PostMapping("/addFriend")
    public String sendFriendRequest(@RequestParam("receiverId") int receiverId) {
        int currentID = globalUserIdService.getCurrentID();
        User sender = userRepo.findById(currentID);
        User receiver = userRepo.findById(receiverId);
        if (receiver != null) {

            FriendRequest existingRequest = friendRequestRepo.findBySenderAndReceiver(sender, receiver);
            if (existingRequest != null) {
                return "redirect:/friends";
            } else {
                // Create a new friend request
                FriendRequest friendRequest = new FriendRequest();
                friendRequest.setSender(sender);
                friendRequest.setReceiver(receiver);
                friendRequest.setStatus(PENDING);
                friendRequestRepo.save(friendRequest);
            }
        }
        return "redirect:/friends";
    }

    @PostMapping("/acceptFriendRequest")
    public String acceptFriendRequest(@RequestParam("requestId") Long requestId) {
        FriendRequest request = friendRequestRepo.findById(requestId).orElse(null);
        if (request != null && request.getStatus() == PENDING) {
            // Update status to ACCEPTED and update friends list
            request.setStatus(ACCEPTED);
            User sender = request.getSender();
            User receiver = request.getReceiver();
            sender.getFriends().add(receiver);
            receiver.getFriends().add(sender);
            userRepo.save(sender);
            userRepo.save(receiver);
        }
        return "redirect:/friends";
    }

    @PostMapping("/rejectFriendRequest")
    public String rejectFriendRequest(@RequestParam("requestId") Long requestId) {
        FriendRequest request = friendRequestRepo.findById(requestId).orElse(null);
        if (request != null && request.getStatus() == PENDING) {
            // Update status to REJECTED
            request.setStatus(REJECTED);
        }
        friendRequestRepo.delete(request);
        return "redirect:/friends";
    }

}
