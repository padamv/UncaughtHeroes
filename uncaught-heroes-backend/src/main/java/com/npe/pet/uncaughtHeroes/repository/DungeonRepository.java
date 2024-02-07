package com.npe.pet.uncaughtHeroes.repository;

import com.npe.pet.uncaughtHeroes.entity.dungeon.Dungeon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DungeonRepository extends MongoRepository <Dungeon, String> {
}