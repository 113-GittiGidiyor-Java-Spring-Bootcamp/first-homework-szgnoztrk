package dev.patika.models;

import javax.persistence.*;

@Entity
@Table(name = "visiting_researchers")
public class VisitingResearcher extends Instructor{
    @Column(name = "vr_hourly_salary")
    private int hourlySalary;

    public VisitingResearcher(String fullName, String address, String phoneNumber, int hourlySalary) {
        super(fullName, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }
    public VisitingResearcher(){}

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
