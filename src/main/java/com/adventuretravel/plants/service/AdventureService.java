package com.adventuretravel.plants.service;

import com.adventuretravel.plants.entities.Adventure;
import com.adventuretravel.plants.repositories.AdventureRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdventureService {
    private final AdventureRepository adventureRepository;

    public AdventureService(AdventureRepository adventureRepository) {
        this.adventureRepository = adventureRepository;
    }

    public Iterable<Adventure> getAllAdventures(){
        return adventureRepository.findAll();
    }

    public List<Adventure> getAdventureByCountry(String country){
        return adventureRepository.findByCountry(country);
    }
    public List<Adventure> getAdventureByState(String state){
        return adventureRepository.findByState(state);
    }
    public void saveAdventure(Adventure adventure){
        adventureRepository.save(adventure);
    }
    public Adventure getAdventureById(int id){
        Optional<Adventure> adventureOptional = this.adventureRepository.findById(id);
        if(adventureOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adventure not found with id: " + id);
        }
        Adventure adv = adventureOptional.get();
        adv.setBlogCompleted(true);
        return adv;
    }
    public void deleteAdventureById(int id){
        Optional<Adventure> adventureOptional = this.adventureRepository.findById(id);
        if(adventureOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adventure not found with id: " + id);
        }
        Adventure adv = adventureOptional.get();
        adventureRepository.delete(adv);
    }
}
