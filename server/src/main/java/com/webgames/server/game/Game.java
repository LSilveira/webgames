package com.webgames.server.game;

import com.webgames.server.game.hangman.GameSessionException;

/**
 * Game interface
 */
public interface Game
{
    /**
     * Starts a new game
     *
     * @return game state
     */
    State start();

    /**
     * Makes a game play
     *
     * @param session game session
     * @return game state
     * @throws GameSessionException when game session is null
     */
    State play(GameSession session) throws GameSessionException;

    /**
     * Get game state
     *
     * @return game state
     */
    State state();
}
