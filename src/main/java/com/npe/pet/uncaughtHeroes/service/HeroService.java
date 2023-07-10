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
    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Hero save(Hero hero) {
        try {
            return heroRepository.save(hero);
        } catch (DuplicateKeyException exception) {
            throw new HeroNameDuplicateException(getHeroNameDuplicateMessage(hero));
        }
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
