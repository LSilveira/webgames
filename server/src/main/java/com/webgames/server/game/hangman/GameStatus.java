package com.webgames.server.game.hangman;

public enum GameStatus
{
    STARTED("Started"),
    WON("Won"),
    LOST("Lost");

    private String description;

    GameStatus(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}
