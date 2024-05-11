package com.example.group19.repository;

import com.example.group19.model.Course;
import com.example.group19.model.CourseReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseReviewRepository extends CrudRepository<CourseReview, Integer> {
    public List<CourseReview> findByCourse(Course course);

}