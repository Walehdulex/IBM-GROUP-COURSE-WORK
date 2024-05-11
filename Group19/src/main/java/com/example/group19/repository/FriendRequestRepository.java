package com.example.group19.repository;

import com.example.group19.model.FriendRequest;
import com.example.group19.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRequestRepository extends CrudRepository<FriendRequest, Long> {
    public FriendRequest findByStatus(Enum status);
    public List<FriendRequest> findByReceiverAndStatus(User user, FriendRequest.Status status);

    public List<FriendRequest> findBySenderAndStatus(User user, FriendRequest.Status status);

    public FriendRequest findBySenderAndReceiver(User Sender, User Receiver);

}
