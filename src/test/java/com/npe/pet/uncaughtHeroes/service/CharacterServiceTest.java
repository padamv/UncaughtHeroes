package com.npe.pet.uncaughtHeroes.service;

import com.npe.pet.uncaughtHeroes.entity.Character;
import com.npe.pet.uncaughtHeroes.repository.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.mockito.Mockito.*;

class CharacterServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    private CharacterService underTest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        underTest = new CharacterService(characterRepository);
    }

    @Test
    void whenFindById_thenReturnMatchingCharacter() {
        Character character = Character.builder().id(1L).name("John").build();
        when(characterRepository.findById(1L)).thenReturn(Optional.of(character));

        Character foundCharacter = underTest.findById(1L);

        Assertions.assertEquals("John", foundCharacter.getName());
        verify(characterRepository, times(1)).findById(1L);
    }
}

