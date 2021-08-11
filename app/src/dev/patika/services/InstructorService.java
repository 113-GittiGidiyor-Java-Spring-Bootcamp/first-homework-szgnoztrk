package dev.patika.services;

import dev.patika.models.Instructor;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorService implements CrudRepository<Instructor> {
    private EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Instructor> findAll() {
        return em.createQuery("SELECT i FROM Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int instructorId) {
        return em.createQuery("SELECT i FROM Instructor i WHERE i.id =:instructorId", Instructor.class).setParameter("instructorId", instructorId).getSingleResult();
    }

    @Override
    public void save(Instructor object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Instructor object) {
        try {
            em.getTransaction().begin();
            em.remove(object);
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
        Instructor instructor = this.findById(id);
        if (instructor != null) {
            em.getTransaction().begin();
            em.remove(instructor);
            em.getTransaction().commit();
        }
        else
            System.out.println("Id:{id}, Eğitmen bulunamadı!");
    }

    @Override
    public void update(Instructor object, int id) {
        Instructor instructor = this.findById(id);
        if (instructor != null) {
            try{
                em.getTransaction().begin();

                instructor.setFullName(object.getFullName());
                instructor.setAddress(object.getAddress());
                instructor.setPhoneNumber(object.getPhoneNumber());
                instructor.setCourses(object.getCourses());

                em.merge(instructor);
                em.getTransaction().commit();
            }catch (Exception ex){
                em.getTransaction().rollback();
            }
        }
    }
}
