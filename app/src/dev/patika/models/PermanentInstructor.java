package dev.patika.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permanent_instructor")
public class PermanentInstructor extends Instructor{
    @Column(name = "vr_fixed_salary")
    private int fixedSalary;

    public PermanentInstructor(String fullName, String address, String phoneNumber, int fixedSalary) {
        super(fullName, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {}

    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
