package com.example.group19.repository;

import com.example.group19.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    Quiz findByCourseId(int courseId);
}
