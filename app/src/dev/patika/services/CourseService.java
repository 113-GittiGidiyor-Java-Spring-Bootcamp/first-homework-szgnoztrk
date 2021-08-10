package dev.patika.services;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CrudRepository<Course> {
    private EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Course> findAll() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return em.createQuery("SELECT c FROM Course c WHERE c.id =:courseId", Course.class).setParameter("courseId", id).getSingleResult();
    }

    @Override
    public void save(Course object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Course object) {
        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(int id) {
        Course course = this.findById(id);
        if (course != null){
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        }
        else
            System.out.println("Id:{id}, Ders bulunamadı!");
    }

    @Override
    public void update(Course object, int id) {
        Course course = this.findById(id);
        if (course != null) {
            try{
                em.getTransaction().begin();

                course.setName(object.getName());
                course.setCode(object.getCode());

                em.merge(course);
                em.getTransaction().commit();
            }catch (Exception ex){
                em.getTransaction().rollback();
            }
        }
    }
}
