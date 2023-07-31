package com.npe.pet.uncaughtHeroes.controller;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.exception.HeroNameDuplicateException;
import com.npe.pet.uncaughtHeroes.exception.HeroNotFoundException;
import com.npe.pet.uncaughtHeroes.model.HeroInput;
import com.npe.pet.uncaughtHeroes.service.HeroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;
    private final Logger logger = LoggerFactory.getLogger(HeroController.class);

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
    public ResponseEntity<Hero> saveHero(@RequestBody HeroInput heroInput) {
        logger.info("Saving a new hero: {}", heroInput.getName());

        try {
            Hero savedHero = heroService.save(heroInput);
            logger.info("Hero saved successfully: {}", savedHero.getName());
            return new ResponseEntity<>(savedHero, HttpStatus.CREATED);
        } catch (HeroNameDuplicateException e) {
            logger.warn("Hero name already exists: {}", heroInput.getName());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            logger.error("Error occurred while saving the hero", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable("id") String id) {
        logger.info("Getting hero by ID: {}", id);
        try {
            Hero hero = heroService.findById(id);
            logger.info("Found hero with ID: {}", hero.getId());
            return ResponseEntity.ok(hero);
        } catch (HeroNotFoundException e) {
            logger.warn("Hero not found with ID: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
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
        try {
            heroService.deleteById(id);
            logger.info("Hero deleted successfully: {}", id);
            return ResponseEntity.noContent().build();
        } catch (HeroNotFoundException e) {
            logger.warn("Hero not found with ID: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
