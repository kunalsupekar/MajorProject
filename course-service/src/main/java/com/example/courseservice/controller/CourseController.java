package com.example.courseservice.controller;

import com.example.courseservice.Services.CourseService;
import com.example.courseservice.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CourseController.java
@RestController
@RequestMapping("/api/courses")
//@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseService coursesService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCourses(@RequestBody List<Courses> courses) {
        coursesService.registerCourses(courses);
        return ResponseEntity.ok("Courses registered successfully");
    }

    @GetMapping("/student/{prn}")
    public ResponseEntity<List<Courses>> getCoursesByStudent(@PathVariable Long prn) {
        List<Courses> studentCourses = coursesService.getCoursesByStudent(prn);
        return ResponseEntity.ok(studentCourses);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> allCourses = coursesService.getAllCourses();
        return ResponseEntity.ok(allCourses);
    }

}
