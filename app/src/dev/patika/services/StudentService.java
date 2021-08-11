package dev.patika.services;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.repository.StudentRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {
    private EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int studentId) {
        return em.createQuery("SELECT s FROM Student s WHERE s.id =:studentId", Student.class).setParameter("studentId", studentId).getSingleResult();
    }

    @Override
    public void save(Student student) {
        try {
            em.getTransaction().begin();
            em.persist(student);
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Student student) {
        try {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }
    
    /*
        Override edilen delete metoduna int tipinde id göndererek ilgili satırı bulursa
        o object üzerinden silme işlemini gerçekleştirecektir.
     */
    @Override
    public void delete(int id) {
        Student student = this.findById(id);
        if (student != null) {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        }
        else
            System.out.println("Id:{id}, Öğrenci bulunamadı!");
    }

    @Override
    public void update(Student object, int studentId) {
        Student student = this.findById(studentId);
        if (student != null) {
            try{
                em.getTransaction().begin();

                student.setFullName(object.getFullName());
                student.setAddress(object.getAddress());
                student.setBirthDate(object.getBirthDate());
                student.setGender(object.getGender());

                em.merge(student);
                em.getTransaction().commit();
            }catch (Exception ex){
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public List<Course> getCourseByStudentId(int studentId) {
        return this.findById(studentId).getCourses();
    }
}
