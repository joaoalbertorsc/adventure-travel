package com.adventuretravel.plants.repositories;

import com.adventuretravel.plants.entities.Adventure;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AdventureRepository extends CrudRepository<Adventure, Integer> {
    public default List<Adventure> findByCountry(String country){
        List<Adventure> adventuresByCountry = new ArrayList<>();
        for(Adventure adventure: this.findAll()){
            if(adventure.getCountry().equals(country)){
                adventuresByCountry.add(adventure);
            }
        }
        return adventuresByCountry;
    }
    public default List<Adventure> findByState(String state){
        List<Adventure> adventuresByState = new ArrayList<>();
        for (Adventure adventure: this.findAll()){
            if (adventure.getState().equals(state)){
                adventuresByState.add(adventure);
            }
        }
        return adventuresByState;
    }
}