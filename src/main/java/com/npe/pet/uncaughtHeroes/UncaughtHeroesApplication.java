package com.npe.pet.uncaughtHeroes;

import com.npe.pet.uncaughtHeroes.util.HeroGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UncaughtHeroesApplication {

	public static void main(String... args) {
		SpringApplication.run(UncaughtHeroesApplication.class, args);
		HeroGenerator heroGenerator = new HeroGenerator();
		System.out.println(heroGenerator.generateCharacter());
	}

}
