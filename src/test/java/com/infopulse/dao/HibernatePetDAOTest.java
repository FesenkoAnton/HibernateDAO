package com.infopulse.dao;

import com.infopulse.entity.Food;
import com.infopulse.entity.Owner;
import com.infopulse.entity.Pet;
import com.infopulse.factory.FactoryPet;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class HibernatePetDAOTest {

    private FactoryPet instance = FactoryPet.getInstance();


    @Test
    public void insertAndSelectEntityTest() {
        PetDAO petDAO = instance.getPetDAO();
        petDAO.deleteAll();

        Pet pet = new Pet();
        pet.setName("Tobik");
        pet.setAnimal("Dog");

        Owner owner = new Owner();
        owner.setOwner_name("Timur");
        owner.setPet(pet);
        pet.setOwner(owner);

        Food food1 =new Food();
        food1.setName("Mnyam mnyam");
        food1.setPet(pet);

        Food food2 =new Food();
        food2.setName("jjjj");
        food2.setPet(pet);

        pet.addFood(food1);
        pet.addFood(food2);

        petDAO.insertPet(pet);

        List<Pet> pets = petDAO.getAllPets();

        Pet petResult = pets.stream()
                .filter(c -> c.getName().equals("Tobik"))
                .findFirst()
                .get();

        assertEquals("Tobik", petResult.getName());
        assertEquals("Dog", petResult.getAnimal());
    }
}