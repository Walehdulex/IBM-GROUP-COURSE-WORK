package com.example.group19.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @SequenceGenerator(name="generator", allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="generator")
    private int id;
    private String username;
    private String name;
    private String password;

    @ManyToMany
    private List<Course> enrolled = new ArrayList<>();
    @ManyToMany
    private List<Course> completed = new ArrayList<>();
    private int coursesCompleted = 0;

    @OneToMany
    private List<CourseReview> reviews = new ArrayList<>();


    public List<Course> getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(List<Course> enrolled) {
        this.enrolled = enrolled;
    }

    public List<Course> getCompleted() {
        return completed;
    }

    public void setCompleted(List<Course> completed) {
        this.completed = completed;
    }

    public int getCoursesCompleted() {
        return coursesCompleted;
    }

    public void setCoursesCompleted(int coursesCompleted) {
        this.coursesCompleted = coursesCompleted;
    }


    public User(int id, String username, String name, String password, int coursesCompleted) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.coursesCompleted = coursesCompleted;
    }

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        password = Password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Username='" + username + '\'' +
                ", Passoword='" + password + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "sender")
    private List<FriendRequest> sentFriendRequests = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<FriendRequest> receivedFriendRequests = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends = new ArrayList<>();

    public List<CourseReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<CourseReview> reviews) {
        this.reviews = reviews;
    }
// Getters and setters...

    public List<FriendRequest> getSentFriendRequests() {
        return sentFriendRequests;
    }

    public List<FriendRequest> getReceivedFriendRequests() {
        return receivedFriendRequests;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public User orElse(Object o) {
        return null;
    }
}

