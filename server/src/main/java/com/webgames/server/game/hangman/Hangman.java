package com.webgames.server.game.hangman;

import com.webgames.server.game.Game;
import com.webgames.server.game.GameSession;
import com.webgames.server.game.State;

public class Hangman implements Game
{
    private String word;
    private HangmanLogic logic;

    public Hangman(String word)
    {
        this.word = word;
    }

    @Override
    public State start()
    {
        logic = new HangmanLogic(word);
        return logic.init();
    }

    @Override
    public State play(GameSession session) throws GameSessionException
    {
        return logic.execute(session);
    }

    @Override
    public State state() {
        return logic.state();
    }
}
