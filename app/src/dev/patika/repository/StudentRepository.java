package dev.patika.repository;

import dev.patika.models.Course;

import java.util.List;

public interface StudentRepository {
    public List<Course> getCourseByStudentId(int studentId);
}
