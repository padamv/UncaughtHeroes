package com.npe.pet.uncaughtHeroes.controller;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.model.HeroInput;
import com.npe.pet.uncaughtHeroes.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;
    private final Logger logger = LoggerFactory.getLogger(HeroController.class);

    @PostMapping
    public ResponseEntity<Hero> saveHero(@RequestBody HeroInput heroInput) {
        logger.info("Saving a new hero: {}", heroInput.getName());
        Hero savedHero = heroService.save(heroInput);
        logger.info("Hero saved successfully: {}", savedHero.getName());
        System.out.println("sdsd");
        return new ResponseEntity<>(savedHero, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable("id") String id) {
        logger.info("Getting hero by ID: {}", id);
        Hero hero = heroService.findById(id);
        logger.info("Found hero with ID: {}", hero.getId());
        return ResponseEntity.ok(hero);
    }

    @GetMapping("/all")
    public List<Hero> getAllHeroes() {
        logger.info("Getting all heroes");
        return heroService.findAll();
    }

    @GetMapping
    public List<Hero> getHeroesWithStrengthGreaterThan(@RequestParam("strengthGreaterThan") int value) {
        logger.info("Getting heroes with strength greater than: {}", value);
        return heroService.findByStrengthGreaterThan(value);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHeroById(@PathVariable("id") String id) {
        logger.info("Deleting hero with ID: {}", id);
        heroService.deleteById(id);
        logger.info("Hero deleted successfully: {}", id);
        return ResponseEntity.noContent().build();
    }
}
