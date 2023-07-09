package com.npe.pet.uncaughtHeroes.factory;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import com.npe.pet.uncaughtHeroes.model.HeroInput;
import com.npe.pet.uncaughtHeroes.modifier.StatModifier;
import com.npe.pet.uncaughtHeroes.modifier.race.RaceModifierProperties;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

@Component
public class HeroFactory {
    private static final int ZERO = 0;
    private final RaceModifierProperties raceModifierProperties;

    public HeroFactory(RaceModifierProperties raceModifierProperties) {
        this.raceModifierProperties = raceModifierProperties;
    }

    public Hero createHero(HeroInput input){
        Hero baseHero = createBaseHero(input);
        Hero heroWithCast = addCastSpecificAttributes(baseHero);
        Hero heroWithCastAndRace = modifyRaceSpecificAttributes(heroWithCast);
        return heroWithCastAndRace;
    }

    private Hero createBaseHero(HeroInput heroInput) {
    return Hero.builder()
            .id(heroInput.getId())
            .name(heroInput.getName())
            .picturePath(heroInput.getPicturePath())
            .description(heroInput.getDescription())
            .race(heroInput.getRace())
            .strength(heroInput.getStrength())
            .dexterity(heroInput.getDexterity())
            .constitution(heroInput.getConstitution())
            .intelligence(heroInput.getIntelligence())
            .wisdom(heroInput.getWisdom())
            .speed(heroInput.getSpeed())
            .charisma(heroInput.getCharisma())
            .weight(heroInput.getWeight())
            .height(heroInput.getHeight())
            .items(heroInput.getItems())
            .skills(heroInput.getSkills())
            .weapons(heroInput.getWeapons())
            .xp(ZERO)
            .build();
    }

    //TODO: when casts are implemented this needs rework
    private Hero addCastSpecificAttributes(Hero hero) {
        hero.setHp(100);
        hero.setMp(100);
        hero.setBaseAttack(10);
        hero.setBaseDefense(10);
        hero.setMaxSpells(0);
        hero.setSpellList(Collections.emptyList());
        hero.getSkills().addAll(Collections.emptyList());
        return hero;
    }

    private Hero modifyRaceSpecificAttributes(Hero hero) {
        List<StatModifier> modifiers = raceModifierProperties.getModifiers().get(hero.getRace());
        if (modifiers != null) {
            for (StatModifier modifier : modifiers) {
                modifyProperty(hero, modifier);
            }
        }
        return hero;
    }

    private void modifyProperty(Hero hero, StatModifier modifier) {
        try {
            Field field = hero.getClass().getDeclaredField(modifier.getPropertyName());
            field.setAccessible(true);
            int originalValue = (int) field.get(hero);
            field.set(hero, originalValue + modifier.getModificationValue());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
