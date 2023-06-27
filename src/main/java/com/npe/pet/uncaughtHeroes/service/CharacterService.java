package com.npe.pet.uncaughtHeroes.service;

import com.npe.pet.uncaughtHeroes.entity.Character;
import com.npe.pet.uncaughtHeroes.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character save(Character character) {
        return characterRepository.save(character);
    }

    public Character findById(Long id) {
        Optional<Character> characterOptional = characterRepository.findById(id);
        return characterOptional.orElse(null);
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public void deleteById(Long id) {
        characterRepository.deleteById(id);
    }

    public List<Character> findByStrengthGreaterThan(int strength) {
        return characterRepository.findByStrengthGreaterThan(strength);
    }
}
