package com.npe.pet.uncaughtHeroes.service;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {
    private final HeroRepository heroRepository;

    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Optional<Hero> save(Hero hero) {
        try {
            return Optional.of(heroRepository.save(hero));
        } catch (DuplicateKeyException duplicateKeyException) {
            return Optional.empty();
        }
    }

    public Hero findById(String id) {
        Optional<Hero> characterOptional = heroRepository.findById(id);
        return characterOptional.orElse(null);
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
