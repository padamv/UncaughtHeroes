package com.npe.pet.uncaughtHeroes.entity.dungeon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "dungeons")
public class Dungeon {

    @MongoId
    String id;

    @Indexed(name = "dungeon_number_index_unique", unique = true)
    int dungeonNumber;

    List<Level> levels;
}