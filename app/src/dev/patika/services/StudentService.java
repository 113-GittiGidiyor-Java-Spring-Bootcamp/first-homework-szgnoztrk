package dev.patika.services;

import dev.patika.models.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student> {
    private EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int studentId) {
        return em.createQuery("SELECT s FROM Student s WHERE s.id =: studentId", Student.class).getSingleResult();
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
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(int id) {
        Student student = this.findById(id);
        if (student != null)
            em.remove(student);
        else
            System.out.println("Öğrenci bulunamadı!");
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
}
