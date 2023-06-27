package com.npe.pet.uncaughtHeroes.repository;

import com.npe.pet.uncaughtHeroes.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findByStrengthGreaterThan(int strength);
}
