package com.example.group19.repository;

import com.example.group19.model.Course;
import com.example.group19.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public List<User> findAll();
    public User findByUsername(String Username);
    public User findById(int id);
    public List<User> findByEnrolled(Course course);
    public List<User> findByCompleted(Course course);
    public List<User>findByUsernameContainingIgnoreCase(String username);
}
