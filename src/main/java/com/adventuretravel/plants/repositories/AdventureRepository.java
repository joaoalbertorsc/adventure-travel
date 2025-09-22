package com.adventuretravel.plants.repositories;

import com.adventuretravel.plants.entities.Adventure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdventureRepository extends CrudRepository<Adventure, Integer> {
    public List<Adventure> findByCountryIgnoreCase(String country);
    public List<Adventure> findByStateIgnoreCase(String state);
}