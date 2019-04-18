package com.busyqa.crm_project.services;

import com.busyqa.crm_project.pojo.control_access.CrmUser;
import com.busyqa.crm_project.pojo.course.Course;
import com.busyqa.crm_project.repositories.CourseRepository;
import com.busyqa.crm_project.repositories.CrmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAdminService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CrmUserRepository crmUserRepository;

    public List<Course> list() {return this.courseRepository.findAll();}

    public Course listById(Long id) {return this.courseRepository.getOne(id);}

    public Course create(Course course) {
        this.courseRepository.save(course);
        return course;
    }

    public ResponseEntity<Course> update(Long id, Course course) {

        return courseRepository.findById(id).map(recordUpdated -> {
            recordUpdated.setCoursePublicId(course.getCoursePublicId());
            recordUpdated.setCourseTitle(course.getCourseTitle());
            recordUpdated.setCourseBatchName(course.getCourseBatchName());
            this.courseRepository.save(recordUpdated);
            return ResponseEntity.ok().body(recordUpdated);
                }).orElse(ResponseEntity.notFound().build());

    }

    public ResponseEntity<?> delete(Long id) {
        return courseRepository.findById(id).map(
                record -> {
                    courseRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    //====== admin setting
    public List<CrmUser> listUser() { return this.crmUserRepository.findAll();}

    public CrmUser addUser(CrmUser crmUser) {
        this.crmUserRepository.save(crmUser);
        return crmUser;
    }

    public CrmUser getUserById(Long id) { return this.crmUserRepository.getOne(id); }

    public ResponseEntity<CrmUser> updateUser(Long id, CrmUser crmUser) {
        return crmUserRepository.findById(id).map(recordUpdated -> {
            recordUpdated.setUserName(crmUser.getUserName());
            recordUpdated.setPassword(crmUser.getPassword());
            recordUpdated.setRole(crmUser.getRole());
            this.crmUserRepository.save(recordUpdated);
            return ResponseEntity.ok().body(recordUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }




}
