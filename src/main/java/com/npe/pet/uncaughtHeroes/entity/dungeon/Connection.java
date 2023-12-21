package com.npe.pet.uncaughtHeroes.entity.dungeon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Connection {

    int roomNumber;
    ConnectionType connectionType;
}