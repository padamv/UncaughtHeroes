package com.npe.pet.uncaughtHeroes.service;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.exception.HeroNameDuplicateException;
import com.npe.pet.uncaughtHeroes.exception.HeroNotFoundException;
import com.npe.pet.uncaughtHeroes.factory.HeroFactory;
import com.npe.pet.uncaughtHeroes.model.HeroInput;
import com.npe.pet.uncaughtHeroes.repository.HeroRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroService {
    private final HeroRepository heroRepository;
    private final HeroFactory heroFactory;

    public HeroService(HeroRepository heroRepository, HeroFactory heroFactory) {
        this.heroRepository = heroRepository;
        this.heroFactory = heroFactory;
    }

    public Hero save(HeroInput heroInput) {
        Hero hero = heroFactory.createHero(heroInput);
        try {
            return heroRepository.save(hero);
        } catch (DuplicateKeyException exception) {
            throw new HeroNameDuplicateException(getHeroNameDuplicateMessage(hero));
        }
    }

    public List<Hero> saveMultipleHeroes(List<HeroInput> heroInputList) {
        List<Hero> heroes = new ArrayList<>();
        for (HeroInput heroInput : heroInputList) {
            heroes.add(save(heroInput));
        }
        return heroes;
    }

    private String getHeroNameDuplicateMessage(Hero hero) {
        String duplicateNameMessage = "'%s' hero already exists.";
        return String.format(duplicateNameMessage, hero.getName());
    }

    public Hero findById(String id) {
        Optional<Hero> characterOptional = heroRepository.findById(id);
        return characterOptional
                .orElseThrow(() -> new HeroNotFoundException(getHeroNotFoundMessage(id)));
    }

    private String getHeroNotFoundMessage(String id) {
        String heroNotFoundMessage = "Hero was not found. (ID: %s)";
        return String.format(heroNotFoundMessage, id);
    }

    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    public void deleteById(String id) {
        heroRepository.deleteById(id);
    }

    public List<Hero> findByStrengthGreaterThan(int strength) {
        return heroRepository.findByStrengthGreaterThan(strength);
    }
}
