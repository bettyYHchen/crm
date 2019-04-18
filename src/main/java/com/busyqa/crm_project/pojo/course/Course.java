package com.busyqa.crm_project.pojo.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="Course")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    private String coursePublicId;
    private String courseTitle;
    private String courseBatchName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoursePublicId() {
        return coursePublicId;
    }

    public void setCoursePublicId(String coursePublicId) {
        this.coursePublicId = coursePublicId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseBatchName() {
        return courseBatchName;
    }

    public void setCourseBatchName(String courseBatchName) {
        this.courseBatchName = courseBatchName;
    }

}
