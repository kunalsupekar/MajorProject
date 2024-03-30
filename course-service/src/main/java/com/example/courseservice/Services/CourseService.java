package com.example.courseservice.Services;

import com.example.courseservice.model.Courses;
import com.example.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void registerCourses(List<Courses> courses) {
        courseRepository.saveAll(courses);
    }

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }


    public List<Courses> getCoursesByStudent(Long prn) {
        return courseRepository.findByPrn(prn);
    }
}
