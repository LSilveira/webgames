package com.webgames.server.rest;

import com.webgames.server.game.Game;
import com.webgames.server.game.State;
import com.webgames.server.game.hangman.GameSessionException;
import com.webgames.server.game.hangman.Hangman;
import com.webgames.server.game.hangman.HangmanSession;
import com.webgames.server.game.util.HangmanUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hangman")
public class HangmanController
{
    private Map<String,Game> games = new HashMap<>();

    @GetMapping
    public State startGame(String playerName)
    {
        Game game = new Hangman(HangmanUtil.getInstance().generateRandomWord());
        State state = game.start();
        games.put(playerName, game);

        return state;
    }

    @PostMapping
    public State playGame(String playerName, String guess) throws GameSessionException
    {
        HangmanSession session = new HangmanSession(guess);
        return  games.get(playerName).play(session);
    }

    @GetMapping("/status")
    public State gameState(String playerName)
    {
        return games.get(playerName).state();
    }
}
