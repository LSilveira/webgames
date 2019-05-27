package com.webgames.server.game.hangman;

import com.webgames.server.game.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class HangmanState implements State
{
    private List<String> words;
    private GameStatus status;
    private int totalGuesses;
}
