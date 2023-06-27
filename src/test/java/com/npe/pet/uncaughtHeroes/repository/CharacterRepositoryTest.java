package com.npe.pet.uncaughtHeroes.repository;

import com.npe.pet.uncaughtHeroes.entity.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
class CharacterRepositoryTest {

    @Autowired
    private CharacterRepository underTest;

    @Test
    void whenFindByStrengthGreaterThan_thenReturnMatchingCharacters() {
        Character character1 = Character.builder().id(1).name("John").strength(10).build();
        Character character2 = Character.builder().id(2).name("Jane").strength(15).build();
        Character character3 = Character.builder().id(3).name("Dave").strength(8).build();

        underTest.saveAll(List.of(character1, character2, character3));

        List<Character> charactersWithStrengthGreaterThanTen = underTest.findByStrengthGreaterThan(10);

        Assertions.assertEquals(1, charactersWithStrengthGreaterThanTen.size());
        Assertions.assertEquals("Jane", charactersWithStrengthGreaterThanTen.get(0).getName());
    }
}
