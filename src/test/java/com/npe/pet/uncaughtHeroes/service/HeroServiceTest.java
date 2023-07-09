package com.npe.pet.uncaughtHeroes.service;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.repository.HeroRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HeroServiceTest {

    private static final String HERO_ID = ObjectId.get().toString();
    private static final int STRENGTH_THRESHOLD = 10;

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
        Hero hero = mock(Hero.class);
        when(heroRepository.save(hero)).thenReturn(hero);

        Hero savedHero = underTest.save(hero);

        assertEquals(hero, savedHero);
        verify(heroRepository, times(1)).save(hero);
    }

    @Test
    void givenHeroId_whenFindById_thenHeroIsFound() {
        Hero hero = mock(Hero.class);
        when(heroRepository.findById(HERO_ID)).thenReturn(Optional.of(hero));

        Hero foundHero = underTest.findById(HERO_ID);

        assertEquals(hero, foundHero);
        verify(heroRepository, times(1)).findById(HERO_ID);
    }

    @Test
    void givenNoParameters_whenFindAll_thenAllHeroesAreFound() {
        List<Hero> heroes = List.of(mock(Hero.class), mock(Hero.class));
        when(heroRepository.findAll()).thenReturn(heroes);

        List<Hero> foundHeroes = underTest.findAll();

        assertEquals(heroes.size(), foundHeroes.size());
        assertEquals(heroes, foundHeroes);
        verify(heroRepository, times(1)).findAll();
    }

    @Test
    void givenHeroId_whenDeleteById_thenHeroIsDeleted() {
        Hero hero = mock(Hero.class);
        when(heroRepository.findById(HERO_ID)).thenReturn(Optional.of(hero));

        underTest.deleteById(HERO_ID);

        verify(heroRepository, times(1)).deleteById(HERO_ID);
    }

    @Test
    void givenStrengthThreshold_whenFindByStrengthGreaterThan_thenHeroesWithGreaterStrengthAreFound() {
        List<Hero> heroes = List.of(mock(Hero.class));
        when(heroRepository.findByStrengthGreaterThan(STRENGTH_THRESHOLD)).thenReturn(heroes);

        List<Hero> foundHeroes = underTest.findByStrengthGreaterThan(STRENGTH_THRESHOLD);

        assertEquals(1, foundHeroes.size());
        assertEquals(heroes.get(0), foundHeroes.get(0));
        verify(heroRepository, times(1)).findByStrengthGreaterThan(STRENGTH_THRESHOLD);
    }

}
