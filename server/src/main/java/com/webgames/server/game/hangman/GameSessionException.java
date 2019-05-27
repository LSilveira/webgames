package com.webgames.server.game.hangman;

import com.webgames.server.game.exception.GameException;

public class GameSessionException extends GameException
{
    public GameSessionException()
    {
    }

    public GameSessionException(String message)
    {
        super(message);
    }

    public GameSessionException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
