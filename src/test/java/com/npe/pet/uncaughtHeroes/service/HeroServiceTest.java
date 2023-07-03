package com.npe.pet.uncaughtHeroes.service;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.repository.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HeroServiceTest {

    @Mock
    private HeroRepository heroRepository;

    private HeroService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new HeroService(heroRepository);
    }

    @Test
    void givenHero_whenSaveHero_thenHeroIsSaved() {
        Hero hero = createHero();
        when(heroRepository.save(hero)).thenReturn(hero);

        Hero savedHero = underTest.save(hero);

        assertEquals(hero, savedHero);
        verify(heroRepository, times(1)).save(hero);
    }

    @Test
    void givenHeroId_whenFindById_thenHeroIsFound() {
        Long heroId = 1L;
        Hero hero = createHero();
        when(heroRepository.findById(heroId)).thenReturn(Optional.of(hero));

        Hero foundHero = underTest.findById(heroId);

        assertEquals(hero, foundHero);
        verify(heroRepository, times(1)).findById(heroId);
    }

    @Test
    void givenNoParameters_whenFindAll_thenAllHeroesAreFound() {
        List<Hero> heroes = Arrays.asList(createHero(), createHero());
        when(heroRepository.findAll()).thenReturn(heroes);

        List<Hero> foundHeroes = underTest.findAll();

        assertEquals(heroes.size(), foundHeroes.size());
        assertEquals(heroes, foundHeroes);
        verify(heroRepository, times(1)).findAll();
    }

    @Test
    void givenHeroId_whenDeleteById_thenHeroIsDeleted() {
        Long heroId = 1L;
        Hero hero = createHero();
        when(heroRepository.findById(heroId)).thenReturn(Optional.of(hero));

        underTest.deleteById(heroId);

        verify(heroRepository, times(1)).deleteById(heroId);
    }

    @Test
    void givenStrengthThreshold_whenFindByStrengthGreaterThan_thenHeroesWithGreaterStrengthAreFound() {
        int strengthThreshold = 10;
        List<Hero> heroes = Collections.singletonList(createHeroWithStrength(15));
        when(heroRepository.findByStrengthGreaterThan(strengthThreshold)).thenReturn(heroes);

        List<Hero> foundHeroes = underTest.findByStrengthGreaterThan(strengthThreshold);

        assertEquals(1, foundHeroes.size());
        assertEquals(heroes.get(0), foundHeroes.get(0));
        verify(heroRepository, times(1)).findByStrengthGreaterThan(strengthThreshold);
    }

    private static Hero createHero() {
        return Hero.builder()
                .name("Hero Name")
                .strength(5)
                .build();
    }

    private static Hero createHeroWithStrength(int strength) {
        return Hero.builder()
                .name("Hero Name")
                .strength(strength)
                .build();
    }
}
