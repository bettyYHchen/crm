package com.busyqa.crm_project.controllers;


import com.busyqa.crm_project.pojo.control_access.CrmUser;
import com.busyqa.crm_project.pojo.course.Course;
import com.busyqa.crm_project.services.CourseAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private CourseAdminService courseAdminService;


    @GetMapping("/courses")
    public List<Course> getCourseList() { return this.courseAdminService.list(); }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public Course createCourse(@RequestBody Course course) { return this.courseAdminService.create(course); }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id) { return this.courseAdminService.listById(id); }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @RequestBody Course course) {
        return courseAdminService.update(id, course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) { return courseAdminService.delete(id); }

    //======== admin setting

    //=== get a list of all users
    @GetMapping("/admin")
    public List<CrmUser> listUser() {
        return this.courseAdminService.listUser();
    }

    //=== add a new user
    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public CrmUser addUser(@RequestBody CrmUser crmUser) {
        return this.courseAdminService.addUser(crmUser);
    }

    //=== get a user
    @GetMapping("/admin/{id}")
    public CrmUser getUser(@PathVariable("id") Long id) {
        return this.courseAdminService.getUserById(id);
    }

    //=== update a user
    @PutMapping("/admin/{id}")
    public ResponseEntity<CrmUser> updateUser(@PathVariable("id") Long id, @RequestBody CrmUser crmUser) {
        return courseAdminService.updateUser(id,crmUser);
    }
}
