package com.webgames.ui.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "hangman.client")
@Data
public class HangmanConfig
{
    private String host;
    private String startGameMethod;
    private String playGameMethod;
}
