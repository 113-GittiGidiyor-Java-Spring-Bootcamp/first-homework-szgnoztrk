package dev.patika.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "student_fullname")
    private String fullName;

    @Column(name = "student_birthdate")
    private LocalDate birthDate;

    @Column(name = "student_address")
    private String address;

    @Column(name = "student_gender")
    private String gender;

    @OneToMany(mappedBy = "student")
    private List<Course> courses;

    public Student(String fullName, LocalDate birthDate, String address, String gender) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
    }

    public Student() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(fullName, student.fullName) && Objects.equals(birthDate, student.birthDate) && Objects.equals(address, student.address) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, birthDate, address, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
