package com.npe.pet.uncaughtHeroes.service;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    public Hero findById(Long id) {
        Optional<Hero> characterOptional = heroRepository.findById(id);
        return characterOptional.orElse(null);
    }

    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    public void deleteById(Long id) {
        heroRepository.deleteById(id);
    }

    public List<Hero> findByStrengthGreaterThan(int strength) {
        return heroRepository.findByStrengthGreaterThan(strength);
    }
}
