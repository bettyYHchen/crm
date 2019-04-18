package com.busyqa.crm_project.repositories;

import com.busyqa.crm_project.pojo.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
