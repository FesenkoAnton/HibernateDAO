package com.infopulse.main;

import com.infopulse.dao.PetDAO;
import com.infopulse.entity.Pet;
import com.infopulse.factory.FactoryPet;

public class Main {

    public static void main(String[] args){

        FactoryPet factoryPet = FactoryPet.getInstance();
        PetDAO petDAO = factoryPet.getPetDAO();
        Pet pet =new Pet();
        pet.setName("aaaaa");
        pet.setAnimal("bbbbbb");
        petDAO.insertPet(pet);
    }
}
