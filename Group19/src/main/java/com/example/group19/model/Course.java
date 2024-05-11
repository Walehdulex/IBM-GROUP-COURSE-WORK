package com.example.group19.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @SequenceGenerator(name="generator", allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="generator")
    private int courseId;

    private String courseName;

    private String courseLink;

    private  Boolean Started;

    private Boolean Finished;
    @OneToMany
    @JoinTable(
            name = "reviews",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<CourseReview> reviews = new ArrayList<>();

    public List<CourseReview> getReviews() {
        return reviews;
    }
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    public Boolean getStarted() {
        return Started;
    }

    public void setStarted(Boolean started) {
        Started = started;
    }

    public Boolean getFinished() {
        return Finished;
    }

    public void setFinished(Boolean finished) {
        Finished = finished;
    }

}