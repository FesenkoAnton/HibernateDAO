package com.infopulse.dao;

import com.infopulse.entity.Pet;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernatePetDAO implements PetDAO{
    private final SessionFactory sessionFactory ;

    public HibernatePetDAO(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @Override
    public void insertPet(Pet pet) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(pet);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Pet> getAllPets() {
        EntityManager entityManager=sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Pet>result = entityManager.createQuery("from Pet", Pet.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager=sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("DELETE from pets");
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
