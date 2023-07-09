package com.npe.pet.uncaughtHeroes.util;

import com.npe.pet.uncaughtHeroes.model.HeroInput;

import java.util.Arrays;

public class HeroInputGenerator {

    // TODO: Create an actual character generator with test data in the future
    public HeroInput generateInput() {
        return HeroInput.builder()
                .name("John")
                .picturePath("/path/to/picture.jpg")
                .description("A mighty warrior")
                .strength(10)
                .dexterity(8)
                .constitution(12)
                .intelligence(6)
                .wisdom(9)
                .speed(7)
                .charisma(11)
                .weight(180)
                .height(180)
                .skills(Arrays.asList("Swordsmanship", "Archery"))
                .weapons(Arrays.asList("Sword", "Bow"))
                .items(Arrays.asList("Health Potion", "Scroll of Teleportation"))
                .build();
    }
}
