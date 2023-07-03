package com.npe.pet.uncaughtHeroes.repository;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@DataMongoTest
class HeroRepositoryTest {

    @MockBean
    private HeroRepository underTest;

    @Test
    void whenFindByStrengthGreaterThan_thenReturnMatchingCharacters() {
        Hero hero1 = Hero.builder().name("John").strength(10).build();
        Hero hero2 = Hero.builder().name("Jane").strength(15).build();
        Hero hero3 = Hero.builder().name("Dave").strength(8).build();

        List<Hero> heroes = Arrays.asList(hero1, hero2, hero3);
        List<Hero> heroesWithStrengthGreaterThanTen = Collections.singletonList(hero2);

        int minStrength = 10;
        when(underTest.findByStrengthGreaterThan(minStrength)).thenReturn(heroesWithStrengthGreaterThanTen);

        List<Hero> result = underTest.findByStrengthGreaterThan(minStrength);

        Assertions.assertEquals(heroesWithStrengthGreaterThanTen.size(), result.size());
        Assertions.assertEquals(heroesWithStrengthGreaterThanTen.get(0).getName(), result.get(0).getName());
    }
}
