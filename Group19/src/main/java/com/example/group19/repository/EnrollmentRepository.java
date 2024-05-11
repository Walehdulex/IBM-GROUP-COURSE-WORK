package com.example.group19.repository;
import com.example.group19.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByUserId(String userId);
    List<Enrollment> findByCourseIdAndUserId(String courseId, String userId);
    List<Enrollment> findByCompletedTrue();
    long countByCompletedTrue();
}
