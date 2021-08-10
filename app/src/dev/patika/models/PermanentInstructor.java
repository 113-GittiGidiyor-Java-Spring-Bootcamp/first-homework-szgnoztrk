package dev.patika.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permanent_instructor")
public class PermanentInstructor extends Instructor{
    @Column(name = "vr_fixed_salary")
    private double fixedSalary;

    public PermanentInstructor(String fullName, String address, String phoneNumber, double fixedSalary) {
        super(fullName, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {}

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
