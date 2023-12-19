package com.npe.pet.uncaughtHeroes.controller;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.model.HeroInput;
import com.npe.pet.uncaughtHeroes.service.HeroService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "Heroes API", version = "0.0.6",
        description = "API for querying, creating and deleting heroes"))
@RestController
@RequestMapping("/api/heroes")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;
    private final Logger logger = LoggerFactory.getLogger(HeroController.class);

    @PostMapping
    @Operation(summary = "Save a hero",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Hero saved"),
                    @ApiResponse(responseCode = "409", description = "Hero name duplication",
                            content = @Content(mediaType = "text/plain", schema = @Schema(type = "string")))
            })
    public ResponseEntity<Hero> saveHero(@RequestBody HeroInput heroInput) {
        logger.info("Saving a new hero: {}", heroInput.getName());
        Hero savedHero = heroService.save(heroInput);
        logger.info("Hero saved successfully: {}", savedHero.getName());
        return new ResponseEntity<>(savedHero, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a hero by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Hero found"),
                    @ApiResponse(responseCode = "404", description = "Hero not found",
                            content = @Content(mediaType = "text/plain", schema = @Schema(type = "string")))
            })
    public ResponseEntity<Hero> getHeroById(@PathVariable("id") String id) {
        logger.info("Getting hero by ID: {}", id);
        Hero hero = heroService.findById(id);
        logger.info("Found hero with ID: {}", hero.getId());
        return ResponseEntity.ok(hero);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all heroes")
    public List<Hero> getAllHeroes() {
        logger.info("Getting all heroes");
        return heroService.findAll();
    }

    @GetMapping
    @Operation(summary = "Get heroes with greater strength than")
    public List<Hero> getHeroesWithStrengthGreaterThan(@RequestParam("strengthGreaterThan") int value) {
        logger.info("Getting heroes with strength greater than: {}", value);
        return heroService.findByStrengthGreaterThan(value);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a hero by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Hero deleted"),
                    @ApiResponse(responseCode = "404", description = "Hero not found",
                            content = @Content(mediaType = "text/plain", schema = @Schema(type = "string")))
            })
    public ResponseEntity<Void> deleteHeroById(@PathVariable("id") String id) {
        logger.info("Deleting hero with ID: {}", id);
        heroService.deleteById(id);
        logger.info("Hero deleted successfully: {}", id);
        return ResponseEntity.noContent().build();
    }
}