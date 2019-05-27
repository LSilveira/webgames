package com.webgames.server.game.hangman;

public class Character
{
    private boolean guessed;
    private String symbol;

    public Character(String symbol)
    {
        this.symbol = symbol;
        this.guessed = false;
    }

    public boolean isValidGuess(String symbol)
    {
        if( !guessed && symbol.equalsIgnoreCase(this.symbol) )
        {
            guessed = true;
        }

        return guessed;
    }

    public String getValue()
    {
        return guessed ? symbol : Constants.UNKNOW_CHARACTER;
    }

    public String getChar()
    {
        return symbol;
    }

    public boolean isGuessed()
    {
        return guessed;
    }
}
