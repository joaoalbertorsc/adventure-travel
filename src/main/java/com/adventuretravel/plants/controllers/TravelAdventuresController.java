package com.adventuretravel.plants.controllers;

import com.adventuretravel.plants.entities.Adventure;
import com.adventuretravel.plants.repositories.AdventureRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/traveladventures")
public class TravelAdventuresController {

    private final AdventureRepository adventureRepository;

    public TravelAdventuresController(AdventureRepository adventureRepo) {
        this.adventureRepository = adventureRepo;
    }

    @GetMapping()
    public Iterable<Adventure> getAllAdventures(){
        Iterable<Adventure> adventures = adventureRepository.findAll();
        return adventures;
    }
    @GetMapping("/bycountry/{country}")
    public List<Adventure> getAdventuresByCountry(@PathVariable ("country") String country){
        List<Adventure> adventuresByCountry = new ArrayList<>();
        for(Adventure adventure: adventureRepository.findAll()){
            if(adventure.getCountry().equals(country)){
                adventuresByCountry.add(adventure);
            }
        }
        return adventuresByCountry;
    }

    @GetMapping("/traveladventures/bystate")
    public List<Adventure> getAdventureByState(@RequestParam(name = "state") String state){
        List<Adventure> adventuresByState = new ArrayList<>();
        for(Adventure adventure: adventureRepository.findAll()){
            if(adventure.getState().equals(state)){
                adventuresByState.add(adventure);
            }
        }
        return adventuresByState;
    }
    @PostMapping("/traveladventures")
    public void saveAdventure(@RequestBody Adventure adventure){
        adventureRepository.save(adventure);
    }
    @PutMapping("/traveladventures/{id}")
    public Adventure getAdventureById(@PathVariable("id") int id, @RequestBody Adventure adventure){
        Optional<Adventure> adventureOptional = this.adventureRepository.findById(id);
        if(!adventureOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adventure not found with id: " + id);
        }
        Adventure adv = adventureOptional.get();
        adv.setBlogCompleted(true);
        return adv;
    }
    @DeleteMapping("/traveladventures/{id}")
    public void deleteAdventureById(@PathVariable("id") int id){
        Optional<Adventure> adventureOptional = this.adventureRepository.findById(id);
        if(!adventureOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adventure not found with id: " + id);
        }
        Adventure adv = adventureOptional.get();
        adventureRepository.delete(adv);
    }
}
