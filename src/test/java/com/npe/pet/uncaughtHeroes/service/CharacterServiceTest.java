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

public class CharacterServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    private CharacterService characterService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        characterService = new CharacterService(characterRepository);
    }

    @Test
    public void testFindById() {
        // Create a test character
        Character character = Character.builder().id(1L).name("John").build();
        when(characterRepository.findById(1L)).thenReturn(Optional.of(character));

        // Test the findById method
        Character foundCharacter = characterService.findById(1L);

        Assertions.assertEquals("John", foundCharacter.getName());
        verify(characterRepository, times(1)).findById(1L);
    }
}

