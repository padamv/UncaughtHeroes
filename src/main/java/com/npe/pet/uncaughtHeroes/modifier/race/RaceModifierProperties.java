package com.npe.pet.uncaughtHeroes.modifier.race;

import com.npe.pet.uncaughtHeroes.configuration.YamlPropertySourceFactory;
import com.npe.pet.uncaughtHeroes.model.Race;
import com.npe.pet.uncaughtHeroes.modifier.StatModifier;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
@PropertySource(value = "classpath:race-modifiers.yaml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties
@Getter
@Setter
public class RaceModifierProperties {
    private Map<Race, List<StatModifier>> modifiers;
}

