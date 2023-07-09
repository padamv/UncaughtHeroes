package com.npe.pet.uncaughtHeroes.util;

import com.npe.pet.uncaughtHeroes.exception.HeroNameDuplicateException;
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
        HeroInputGenerator heroInputGenerator = new HeroInputGenerator();
        try {
            heroService.save(heroInputGenerator.generateInput());
        } catch (HeroNameDuplicateException ignored) {

        }
    }
}
