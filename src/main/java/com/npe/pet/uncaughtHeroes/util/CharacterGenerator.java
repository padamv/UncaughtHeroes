package com.npe.pet.uncaughtHeroes.util;

import com.npe.pet.uncaughtHeroes.entity.Character;

import java.util.Arrays;

public class CharacterGenerator {

    // TODO: Create an actual character generator with test data in the future
    public Character generateCharacter() {
        return Character.builder()
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
                .xp(100)
                .mp(50)
                .hp(200)
                .baseAttack(15)
                .baseDefense(12)
                .maxSpells(5)
                .carryingCapacity(100)
                .weight(180)
                .height(180)
                .skills(Arrays.asList("Swordsmanship", "Archery"))
                .weapons(Arrays.asList("Sword", "Bow"))
                .spellList(Arrays.asList("Fireball", "Healing"))
                .items(Arrays.asList("Health Potion", "Scroll of Teleportation"))
                .build();
    }
}
