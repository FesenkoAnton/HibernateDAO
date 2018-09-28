package com.infopulse.factory;

import com.infopulse.dao.HibernatePetDAO;
import com.infopulse.dao.PetDAO;
import org.hibernate.SessionFactory;

import javax.persistence.Persistence;

public class FactoryPet{
    final static FactoryPet INSTANCE = new FactoryPet();

    final private SessionFactory sessionFactory;

    public FactoryPet(){
        sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
    }

    public static FactoryPet getInstance(){
        return INSTANCE;
    }

    public PetDAO getPetDAO(){
        return new HibernatePetDAO(sessionFactory);
    }
}

