package com.npe.pet.uncaughtHeroes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class JsonService {

    private final ObjectMapper mapper;
    private final FileUtil fileUtil;

    public void toJson(Hero hero) {
        toJson(hero, hero.getName());
    }

    public void toJson(Hero hero, String fileName) {
        String fileNameWithExtension = fileName + ".json";
        writeToFile(hero, fileNameWithExtension);
    }

    private void writeToFile(Hero hero, String fileNameWithExtension) {
        try {
            File file = fileUtil.openFile(fileNameWithExtension);
            mapper.writeValue(file, hero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}