package com.infopulse.dao;

import com.infopulse.entity.Pet;

import java.util.List;

public interface PetDAO {
    void insertPet(Pet pet);
    List<Pet> getAllPets();
    void deleteAll();
}
