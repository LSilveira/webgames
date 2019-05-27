package com.webgames.ui.client;

import com.webgames.ui.exception.InvalidRequestException;
import com.webgames.ui.response.GameState;
import com.webgames.ui.service.HangmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HangmanClient implements GameClient
{
    @Autowired
    private HangmanService service;

    @Override
    public GameState start(String playerName) throws InvalidRequestException
    {
        ResponseEntity<GameState> response = service.startGame(playerName);
//        GameState gameState = service.startGame(playerName);
//        return gameState;

        if (response.getStatusCode() != HttpStatus.OK)
        {
            throw new InvalidRequestException("Response code: " + response.getStatusCode().name() + "\nResponseBody: " + response.getBody());
        }

        return response.getBody();
    }

    @Override
    public GameState play(String playerName, String guessWord) throws InvalidRequestException
    {
        ResponseEntity<GameState> response = service.playGame(playerName, guessWord);

        if (response.getStatusCode() != HttpStatus.OK)
        {
            throw new InvalidRequestException("Response code: " + response.getStatusCode().name() + "\nResponseBody: " + response.getBody());
        }

        return response.getBody();
    }
}
