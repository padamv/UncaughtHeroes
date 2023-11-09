package com.npe.pet.uncaughtHeroes.entity;

import com.npe.pet.uncaughtHeroes.model.Race;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "heroes")
public class Hero {

    @MongoId
    private String id;

    @Indexed(name = "hero_name_index_unique", unique = true)
    private String name;
    private String picturePath;
    private String description;
    private Race race;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int speed;
    private int charisma;
    private int xp;
    private int mp;
    private int hp;
    private int baseAttack;
    private int baseDefense;
    private int maxSpells;
    private int carryingCapacity;
    private int weight;
    private int height;

    // TODO: In the future we should create ENUMS for the skills, weapons, items and spellList when we have an actual list of them
    private List<String> skills;
    private List<String> weapons;
    private List<String> spellList;
    private List<String> items;

}