package dev.patika.clients;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.models.Student;
import dev.patika.models.VisitingResearcher;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

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
        Instructor instructor2 = new VisitingResearcher("Abdullah Talha Kabakuş", "Sakarya", "+906664443322", 120);
        Instructor instructor3 = new VisitingResearcher("Resul Kara", "Düzce", "+905559993322", 200);

        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student1.getCourses().add(course3);
        student2.getCourses().add(course2);
        student2.getCourses().add(course3);
        student3.getCourses().add(course1);
        student4.getCourses().add(course3);

        instructor1.getCourses().add(course3);
        instructor2.getCourses().add(course1);
        instructor3.getCourses().add(course2);

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
