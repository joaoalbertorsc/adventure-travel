package com.adventuretravel.plants.controllers;

import com.adventuretravel.plants.entities.Adventure;
import com.adventuretravel.plants.service.AdventureService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/traveladventures")
public class TravelAdventuresController {

    private final AdventureService adventureService;
    public TravelAdventuresController(AdventureService adventureServ) {
        this.adventureService = adventureServ;
    }
    @GetMapping()
    public Iterable<Adventure> getAllAdventures(){
        return adventureService.getAllAdventures();
    }
    @GetMapping("/bycountry/{country}")
    public List<Adventure> getAdventuresByCountry(@PathVariable ("country") String country){
        if (country != null){
            return adventureService.getAdventureByCountry(country);
        }else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/traveladventures/bystate")
    public List<Adventure> getAdventureByState(@RequestParam(name = "state") String state){
        if (state != null){
            return adventureService.getAdventureByState(state);
        }else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/traveladventures/{id}")
    public Adventure getAdventureById(@PathVariable("id") Integer id){
        return adventureService.getAdventureById(id);
    }

    @PostMapping("/traveladventures")
    public void saveAdventure(@RequestBody Adventure adventure){
        if (adventure != null){
            adventureService.saveAdventure(adventure);
        }else {
            throw new NullPointerException("Invalid Adventure. Try Again.");
        }
    }
    @DeleteMapping("/traveladventures/{id}")
    public void deleteAdventureById(@PathVariable("id") Integer id){
        adventureService.deleteAdventureById(id);
    }
}
