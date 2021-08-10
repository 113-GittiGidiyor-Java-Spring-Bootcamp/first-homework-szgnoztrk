package dev.patika.clients;

import dev.patika.models.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    public static void main(String[] args) {
        if(checkTestData() == 0)
            saveTestData();
    }

    private static int checkTestData() {
        return em.createQuery("from Student", Student.class).getResultList().size();
    }

    private static void saveTestData() {
        Student student1 = new Student("Sezgin Öztürk", LocalDate.of(1996, Month.OCTOBER, 24), "Esenyurt/İstanbul", "Erkek");
        Student student2 = new Student("İclal Boyacı", LocalDate.of(2001, Month.FEBRUARY, 6), "Bağcılar/İstanbul", "Kadın");
        Student student3 = new Student("İrfan Can Kahveci", LocalDate.of(1994, Month.MAY, 19), "Kadıköy/İstanbul", "Erkek");
        Student student4 = new Student("Sezer Öztürk", LocalDate.of(1996, Month.APRIL, 22), "Avcılar/İstanbul", "Erkek");

        Course course1 = new Course("Programlamaya Giriş", "BM123", 4);
        Course course2 = new Course("Gömülü Sistemler", "BM234", 5);
        Course course3 = new Course("Java Programlama", "BM345", 5);

        Instructor instructor1 = new VisitingResearcher("Koray Güney", "İstanbul", "+905554443322", 150);
        Instructor instructor2 = new PermanentInstructor("Abdullah Talha Kabakuş", "Sakarya", "+906664443322", 9000);
        Instructor instructor3 = new VisitingResearcher("Resul Kara", "Düzce", "+905559993322", 200);

        List<Course> student1Courses = new ArrayList<>();
        student1Courses.add(course1);
        student1Courses.add(course2);
        student1Courses.add(course3);
        student1.setCourses(student1Courses);

        List<Course> student2Courses = new ArrayList<>();
        student2Courses.add(course3);
        student2.setCourses(student2Courses);

        List<Course> student3Courses = new ArrayList<>();
        student3Courses.add(course1);
        student3Courses.add(course2);
        student3.setCourses(student3Courses);

        List<Course> student4Courses = new ArrayList<>();
        student4Courses.add(course1);
        student4Courses.add(course3);
        student4.setCourses(student4Courses);

        course1.setInstructor(instructor2);
        course2.setInstructor(instructor3);
        course3.setInstructor(instructor1);

        try {
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.persist(instructor1);
            em.persist(instructor2);
            em.persist(instructor3);

            em.getTransaction().commit();
            System.out.println("All data inserting done...");
        }catch (Exception sqlException){
            em.getTransaction().rollback();
        }
    }


}
