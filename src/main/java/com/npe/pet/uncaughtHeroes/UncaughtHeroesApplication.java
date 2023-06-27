package com.npe.pet.uncaughtHeroes;

import com.npe.pet.uncaughtHeroes.util.CharacterGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UncaughtHeroesApplication {

	public static void main(String... args) {
		SpringApplication.run(UncaughtHeroesApplication.class, args);
		CharacterGenerator characterGenerator = new CharacterGenerator();
		System.out.println(characterGenerator.generateCharacter());
	}

}
