package com.npe.pet.uncaughtHeroes.configuration;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Map;

public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        Yaml yaml = new Yaml();
        Map<String, Object> properties = yaml.load(resource.getInputStream());
        return new MapPropertySource("yamlPropertySource", properties);
    }
}

