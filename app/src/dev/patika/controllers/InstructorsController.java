package dev.patika.controllers;

import dev.patika.models.Instructor;
import dev.patika.services.InstructorService;

import java.util.List;

public class InstructorsController {
    private InstructorService instructorService = new InstructorService();

    public List<Instructor> getAll(){ return instructorService.findAll(); }

    public Instructor getById(int instructorId) { return instructorService.findById(instructorId); }

    public void save(Instructor instructor) { instructorService.save(instructor); }

    public void delete(int instructorId) { instructorService.delete(instructorId); }

    public void update(int instructorId, Instructor instructor) { instructorService.update(instructor, instructorId); }
}
