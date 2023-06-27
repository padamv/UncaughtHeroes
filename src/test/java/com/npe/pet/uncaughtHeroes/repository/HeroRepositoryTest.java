package com.npe.pet.uncaughtHeroes.repository;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
class HeroRepositoryTest {

    @Autowired
    private HeroRepository underTest;

    @Test
    void whenFindByStrengthGreaterThan_thenReturnMatchingCharacters() {
        Hero hero1 = Hero.builder().id(1).name("John").strength(10).build();
        Hero hero2 = Hero.builder().id(2).name("Jane").strength(15).build();
        Hero hero3 = Hero.builder().id(3).name("Dave").strength(8).build();

        underTest.saveAll(List.of(hero1, hero2, hero3));

        List<Hero> charactersWithStrengthGreaterThanTen = underTest.findByStrengthGreaterThan(10);

        Assertions.assertEquals(1, charactersWithStrengthGreaterThanTen.size());
        Assertions.assertEquals("Jane", charactersWithStrengthGreaterThanTen.get(0).getName());
    }
}
