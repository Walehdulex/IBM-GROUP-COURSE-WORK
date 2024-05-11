package com.example.group19.repository;

import com.example.group19.model.Course;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public interface CourseRepository extends CrudRepository<Course, Integer> {
    public List<Course> findAll();
    public Course findByCourseId(int id);
    public Course findByCourseName(String name);
}
