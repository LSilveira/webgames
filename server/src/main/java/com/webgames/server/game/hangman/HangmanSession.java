package com.webgames.server.game.hangman;

import com.webgames.server.game.GameSession;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HangmanSession implements GameSession
{
    private String guess;
}
