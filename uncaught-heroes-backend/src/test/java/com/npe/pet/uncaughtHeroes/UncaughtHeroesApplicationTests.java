package com.npe.pet.uncaughtHeroes;

import com.npe.pet.uncaughtHeroes.repository.DungeonRepository;
import com.npe.pet.uncaughtHeroes.repository.HeroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration")
class UncaughtHeroesApplicationTests {

	@MockBean
	private HeroRepository repository;

	@MockBean
	private DungeonRepository dungeonRepository;

	@Test
	void contextLoads() {
	}

}
