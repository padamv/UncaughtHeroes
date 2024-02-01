package com.npe.pet.uncaughtHeroes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.util.FileUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class JsonServiceTest {

    private static final String HERO_NAME = "Name";
    private static final String HERO_NAME_WITH_EXTENSION = "Name.json";
    private static final String FILE_NAME = "Test";
    private static final String FILE_NAME_WITH_EXTENSION = "Test.json";

    @Mock
    private ObjectMapper mapper;
    @Mock
    private FileUtil fileUtil;

    @InjectMocks
    private JsonService underTest;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void testToJson_shouldOpenFileWithHeroNameAndWriteIt_whenOnlyHeroSupplied() throws IOException {
        //given
        Hero hero = mock(Hero.class);
        given(hero.getName()).willReturn(HERO_NAME);
        File file = mock(File.class);
        given(fileUtil.openFile(HERO_NAME_WITH_EXTENSION)).willReturn(file);

        //when
        underTest.toJson(hero);

        //then
        then(hero).should().getName();
        then(fileUtil).should().openFile(HERO_NAME_WITH_EXTENSION);
        then(mapper).should().writeValue(file, hero);
    }

    @Test
    void testToJson_shouldThrowRuntimeException_whenMapperThrowsIOException() throws IOException {
        //given
        Hero hero = mock(Hero.class);
        given(hero.getName()).willReturn(HERO_NAME);
        File file = mock(File.class);
        given(fileUtil.openFile(HERO_NAME_WITH_EXTENSION)).willReturn(file);
        doThrow(IOException.class).when(mapper).writeValue(file, hero);

        //when
        assertThrows(RuntimeException.class, () -> underTest.toJson(hero));

        //then
        then(hero).should().getName();
        then(fileUtil).should().openFile(HERO_NAME_WITH_EXTENSION);
        then(mapper).should().writeValue(file, hero);
    }

    @Test
    void testToJson_shouldOpenFileWithNameAndWriteIt_whenFileNameAndHeroSupplied() throws IOException {
        Hero hero = mock(Hero.class);
        File file = mock(File.class);
        given(fileUtil.openFile(FILE_NAME_WITH_EXTENSION)).willReturn(file);

        //when
        underTest.toJson(hero, FILE_NAME);

        //then
        then(fileUtil).should().openFile(FILE_NAME_WITH_EXTENSION);
        then(mapper).should().writeValue(file, hero);
    }
}