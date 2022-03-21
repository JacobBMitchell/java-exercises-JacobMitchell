package data;

import model.Pet;

import java.util.List;

public interface PetRepository {
    List<Pet> findAll();

    Pet findById(int petId);

    Pet add(Pet pet);

    boolean update(Pet pet);

    boolean deleteById(int petId);
}
