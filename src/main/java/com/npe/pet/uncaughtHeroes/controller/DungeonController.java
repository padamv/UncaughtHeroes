package com.npe.pet.uncaughtHeroes.controller;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@OpenAPIDefinition(info = @Info(title = "Dungeons API", version = "0.0.6",
        description = "API for querying, creating and deleting dungeons"))
@RestController
@RequestMapping("/api/dungeons")
@RequiredArgsConstructor
public class DungeonController {
}
