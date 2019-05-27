package com.webgames.ui.client;

import com.webgames.ui.exception.InvalidRequestException;
import com.webgames.ui.response.GameState;

public interface GameClient
{
    GameState start(String playerName) throws InvalidRequestException;
    GameState play(String playerName, String guessWord) throws InvalidRequestException;
}
