package de.unibayreuth.se.teaching.list.data.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("seubt.list")
public record ListConfiguration(
        Integer maxLength
) {}
