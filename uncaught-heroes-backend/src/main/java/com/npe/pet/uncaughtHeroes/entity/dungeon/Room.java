package com.npe.pet.uncaughtHeroes.entity.dungeon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    int roomNumber;
    String description;
    Set<Connection> connections;
}