package dev.patika.controllers;

import dev.patika.models.Student;
import dev.patika.services.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService = new StudentService();

    public List<Student> getAll(){ return studentService.findAll(); }

    public Student getById(int studentId) { return studentService.findById(studentId); }

    public void save(Student student) {
        studentService.save(student);
        System.out.println(student.getFullName() + " isimli öğrenci eklendi.");
    }

    public void delete(Student student, int studentId){
        if(student != null && studentId != 0)
            studentService.delete(student);
        else if(student == null)
            studentService.delete(studentId);
        else if (studentId == 0)
            studentService.delete(student);
        else {
            System.out.println("Herhangi bir bilgi girilmedi.");
            return;
        }
        System.out.println("Kayıt silindi.");
    }

    public void update()
}
