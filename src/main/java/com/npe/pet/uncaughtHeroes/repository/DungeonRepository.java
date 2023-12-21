package com.npe.pet.uncaughtHeroes.repository;

import com.npe.pet.uncaughtHeroes.entity.dungeon.Dungeon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DungeonRepository extends MongoRepository <Dungeon, String> {

}