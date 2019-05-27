package com.webgames.ui.service;

import com.webgames.ui.config.HangmanConfig;
import com.webgames.ui.response.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class HangmanService
{
    @Autowired
    private HangmanConfig config;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<GameState> startGame(String playerName)
    {
        return restTemplate.getForEntity(config.getHost() + config.getStartGameMethod() + "?playerName=" + playerName, GameState.class);
    }

    public ResponseEntity<GameState> playGame(String playerName, String guessWord)
    {
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("playerName", playerName);
        parts.add("guess", guessWord);

        return restTemplate.postForEntity(config.getHost() + config.getPlayGameMethod(), parts, GameState.class);
    }
}
