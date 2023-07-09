package com.npe.pet.uncaughtHeroes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class HeroInput {
    private String id;
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
    private int weight;
    private int height;
    private List<String> skills;
    private List<String> items;
    private List<String> weapons;
}
