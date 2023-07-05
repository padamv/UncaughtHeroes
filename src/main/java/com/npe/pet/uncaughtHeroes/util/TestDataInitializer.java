package com.npe.pet.uncaughtHeroes.util;

import com.mongodb.DuplicateKeyException;
import com.npe.pet.uncaughtHeroes.service.HeroService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer {

    private final HeroService heroService;

    public TestDataInitializer(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostConstruct
    public void initializeTestData() {
        HeroGenerator heroGenerator = new HeroGenerator();
        try {
            heroService.save(heroGenerator.generateCharacter());
        } catch (DuplicateKeyException ignored) {

        }
    }
}
