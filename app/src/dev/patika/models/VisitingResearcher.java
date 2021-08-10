package dev.patika.models;

import javax.persistence.*;

@Entity
@Table(name = "visiting_researchers")
public class VisitingResearcher extends Instructor{
    @Column(name = "vr_hourly_salary")
    private double hourlySalary;

    public VisitingResearcher(String fullName, String address, String phoneNumber, double hourlySalary) {
        super(fullName, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }
    public VisitingResearcher(){}

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
