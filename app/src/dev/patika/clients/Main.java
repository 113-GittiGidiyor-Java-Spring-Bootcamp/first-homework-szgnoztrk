package dev.patika.clients;

import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        em.getTransaction().begin();

        em.getTransaction().commit();

        EntityManagerUtils.closeEntityManager(em);
    }
}
