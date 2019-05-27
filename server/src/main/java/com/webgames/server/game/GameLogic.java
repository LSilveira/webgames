package com.webgames.server.game;

import com.webgames.server.game.hangman.GameSessionException;

/**
 * Game logic
 */
public interface GameLogic
{
    /**
     * Start a new game logic
     *
     * @return state
     */
    State init();

    /**
     * Executes the game logic
     *
     * @param gameSession game session
     * @return state
     * @throws GameSessionException when game session is null
     */
    State execute(GameSession gameSession) throws GameSessionException;

    /**
     * Gets the game state
     *
     * @return state
     */
    State state();
}
