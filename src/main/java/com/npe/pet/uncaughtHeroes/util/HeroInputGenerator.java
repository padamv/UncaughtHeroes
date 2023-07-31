package com.npe.pet.uncaughtHeroes.util;

import com.npe.pet.uncaughtHeroes.model.HeroInput;
import com.npe.pet.uncaughtHeroes.model.Race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeroInputGenerator {

    // TODO: Create an actual character generator with test data in the future
   public List<HeroInput> generateInputForMultipleHeroes() {
        List<HeroInput> heroInputs = new ArrayList<>();
        heroInputs.add(HeroInput.builder()
                .name("John")
                .picturePath("../images/hero_1.png")
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
                .race(Race.HUMAN)
                .skills(Arrays.asList("Swordsmanship", "Archery"))
                .weapons(Arrays.asList("Sword", "Bow"))
                .items(Arrays.asList("Health Potion", "Scroll of Teleportation"))
                .build());

        heroInputs.add(HeroInput.builder()
                .name("Luke")
                .picturePath("../images/hero_2.png")
                .description("A skilled mage")
                .strength(6)
                .dexterity(10)
                .constitution(8)
                .intelligence(14)
                .wisdom(12)
                .speed(9)
                .charisma(11)
                .weight(160)
                .height(165)
                .race(Race.DWARF)
                .skills(Arrays.asList("Spellcasting", "Alchemy"))
                .weapons(Arrays.asList("Staff", "Dagger"))
                .items(Arrays.asList("Mana Potion", "Book of Spells"))
                .build());

        return heroInputs;
    }
}
