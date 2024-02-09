package com.adventuretravel.plants.controllers;

import com.adventuretravel.plants.entities.Adventure;
import com.adventuretravel.plants.service.AdventureService;
import org.springframework.web.bind.annotation.*;

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
        return adventureService.getAdventureByCountry(country);
    }

    @GetMapping("/traveladventures/bystate")
    public List<Adventure> getAdventureByState(@RequestParam(name = "state") String state){
        return adventureService.getAdventureByState(state);
    }
    @PostMapping("/traveladventures")
    public void saveAdventure(@RequestBody Adventure adventure){
        adventureService.saveAdventure(adventure);
    }
    @PutMapping("/traveladventures/{id}")
    public Adventure getAdventureById(@PathVariable("id") int id, @RequestBody Adventure adventure){
        return adventureService.getAdventureById(id);
    }
    @DeleteMapping("/traveladventures/{id}")
    public void deleteAdventureById(@PathVariable("id") int id){
        adventureService.deleteAdventureById(id);
    }
}
