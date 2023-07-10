package com.npe.pet.uncaughtHeroes.exception;

public class HeroNotFoundException extends RuntimeException {
    public HeroNotFoundException(String heroId) {
        super(heroId);
    }
}
