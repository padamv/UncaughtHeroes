package com.npe.pet.uncaughtHeroes.modifier;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StatModifier {

    private String propertyName;
    private int modificationValue;

    public StatModifier(String propertyName, int modificationValue) {
        this.propertyName = propertyName;
        this.modificationValue = modificationValue;
    }

    }
