package com.npe.pet.uncaughtHeroes.controller;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
    public ResponseEntity<Hero> saveHero(@RequestBody Hero hero) {
        Optional<Hero> savedHero = heroService.save(hero);
        return savedHero.map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.CONFLICT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable("id") String id) {
        Hero hero = heroService.findById(id);
        if (hero != null) {
            return ResponseEntity.ok(hero);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.findAll();
    }

    @GetMapping("/strength/{value}")
    public List<Hero> getHeroesWithStrengthGreaterThan(@PathVariable("value") int value) {
        return heroService.findByStrengthGreaterThan(value);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHeroById(@PathVariable("id") String id) {
        heroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
