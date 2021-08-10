package dev.patika.controllers;


import dev.patika.models.Course;
import dev.patika.services.CourseService;

import java.util.List;

public class CoursesController {
    private CourseService courseService = new CourseService();

    public List<Course> getAll(){ return this.courseService.findAll(); }

    public Course getById(int instructorId) { return this.courseService.findById(instructorId); }

    public void save(Course course) { this.courseService.save(course); }

    public void delete(int courseId) { this.courseService.delete(courseId); }

    public void update(int courseId, Course course) { this.courseService.update(course, courseId); }
}
