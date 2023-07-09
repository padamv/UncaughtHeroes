package com.npe.pet.uncaughtHeroes.service;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.exception.HeroNameDuplicateException;
import com.npe.pet.uncaughtHeroes.exception.HeroNotFoundException;
import com.npe.pet.uncaughtHeroes.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {
    private static final String HERO_NAME_DUPLICATE_MESSAGE = "'%s' hero already exists.";
    private static final String HERO_NOT_FOUND_MESSAGE = "Hero was not found. (ID: %s)";
    private final HeroRepository heroRepository;

    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Hero save(Hero hero) {
        try {
            return heroRepository.save(hero);
        } catch (DuplicateKeyException exception) {
            throw new HeroNameDuplicateException(String.format(HERO_NAME_DUPLICATE_MESSAGE, hero.getName()));
        }
    }

    public Hero findById(String id) {
        Optional<Hero> characterOptional = heroRepository.findById(id);
        return characterOptional
                .orElseThrow(() -> new HeroNotFoundException(String.format(HERO_NOT_FOUND_MESSAGE, id)));
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
