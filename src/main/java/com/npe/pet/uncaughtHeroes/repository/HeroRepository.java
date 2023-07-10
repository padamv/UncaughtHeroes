package com.npe.pet.uncaughtHeroes.repository;

import com.npe.pet.uncaughtHeroes.entity.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HeroRepository extends MongoRepository<Hero, String> {

    List<Hero> findByStrengthGreaterThan(int strength);
}
