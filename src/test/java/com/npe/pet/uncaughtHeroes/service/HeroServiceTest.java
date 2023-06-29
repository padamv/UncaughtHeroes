package com.npe.pet.uncaughtHeroes.service;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.repository.HeroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.mockito.Mockito.*;

class HeroServiceTest {

    @Mock
    private HeroRepository heroRepository;

    private HeroService underTest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        underTest = new HeroService(heroRepository);
    }

    @Test
    void whenFindById_thenReturnMatchingCharacter() {
        Hero hero = Hero.builder().id(1L).name("John").build();
        when(heroRepository.findById(1L)).thenReturn(Optional.of(hero));

        Hero foundHero = underTest.findById(1L);

        Assertions.assertEquals("John", foundHero.getName());
        verify(heroRepository, times(1)).findById(1L);
    }
}

