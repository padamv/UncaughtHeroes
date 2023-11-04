package com.npe.pet.uncaughtHeroes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.npe.pet.uncaughtHeroes.entity.Hero;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class JsonService {

    private final ObjectMapper mapper = new ObjectMapper();

    public void toJson(Hero hero) {
        String fileName = hero.getName() + ".json";
        writeToFile(hero, fileName);
    }

    public void toJson(Hero hero, String fileName) {
        writeToFile(hero, fileName);
    }

    private void writeToFile(Hero hero, String fileName) {
        try {
            File file = new File(fileName);
            mapper.writeValue(file, hero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}