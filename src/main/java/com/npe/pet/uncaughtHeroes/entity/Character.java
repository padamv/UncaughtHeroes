package com.npe.pet.uncaughtHeroes.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Character {
    private String name;
    private String picturePath;
    private String description;

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