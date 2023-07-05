package com.npe.pet.uncaughtHeroes.util;

import com.npe.pet.uncaughtHeroes.repository.HeroRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer {

    private final HeroRepository heroRepository;

    public TestDataInitializer(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @PostConstruct
    public void initializeTestData() {
        HeroGenerator heroGenerator = new HeroGenerator();
        heroRepository.save(heroGenerator.generateCharacter());
    }
}
