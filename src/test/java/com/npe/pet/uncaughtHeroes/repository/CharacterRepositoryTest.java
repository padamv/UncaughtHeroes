package com.npe.pet.uncaughtHeroes.repository;

import com.npe.pet.uncaughtHeroes.entity.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class CharacterRepositoryTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    public void testFindByStrengthGreaterThan() {
        // Create test characters
        Character character1 = Character.builder().id(1).name("John").strength(10).build();
        Character character2 = Character.builder().id(2).name("Jane").strength(15).build();
        Character character3 = Character.builder().id(3).name("Dave").strength(8).build();

        characterRepository.saveAll(List.of(character1, character2, character3));

        // Test the findByStrengthGreaterThan method
        List<Character> charactersWithStrengthGreaterThanTen = characterRepository.findByStrengthGreaterThan(10);

        Assertions.assertEquals(1, charactersWithStrengthGreaterThanTen.size());
        Assertions.assertEquals("Jane", charactersWithStrengthGreaterThanTen.get(0).getName());
    }
}
