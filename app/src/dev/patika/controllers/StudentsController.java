package dev.patika.controllers;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.services.StudentService;

import java.util.List;

public class StudentsController {

    private StudentService studentService = new StudentService();

    public List<Student> getAll(){ return studentService.findAll(); }

    public Student getById(int studentId) { return studentService.findById(studentId); }

    public void save(Student student) { studentService.save(student); }

    public void delete(int studentId) { studentService.delete(studentId); }

    public void update(int studentId, Student student) { studentService.update(student, studentId); }

    public List<Course> getCoursesByStudent(int studentId) { return studentService.getCourseByStudentId(studentId); }
}
