package com.npe.pet.uncaughtHeroes.controller;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.exception.HeroNotFoundException;
import com.npe.pet.uncaughtHeroes.model.HeroInput;
import com.npe.pet.uncaughtHeroes.service.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
    public ResponseEntity<Hero> saveHero(@RequestBody HeroInput heroInput) {
        Hero savedHero = heroService.save(heroInput);
        return new ResponseEntity<>(savedHero, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable("id") String id) {
        Hero hero = heroService.findById(id);
        return ResponseEntity.ok(hero);
    }

    @GetMapping("/all")
    public List<Hero> getAllHeroes() {
        return heroService.findAll();
    }

    @GetMapping
    public List<Hero> getHeroesWithStrengthGreaterThan(@RequestParam("strengthGreaterThan") int value) {
        return heroService.findByStrengthGreaterThan(value);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHeroById(@PathVariable("id") String id) {
        try {
            heroService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (HeroNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
