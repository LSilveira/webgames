package com.webgames.server.game.hangman;

import com.webgames.server.game.GameSession;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanTest
{
    private Hangman hangman;

    @BeforeEach
    void setUp()
    {
        hangman = new Hangman("Computer");
        hangman.start();
    }

    @Test
    void startNullGameSession()
    {
        Assertions.assertThrows(GameSessionException.class, () -> hangman.play(null));
    }

    @Test
    void guessCharLoseGame() throws GameSessionException
    {
        GameSession session = new HangmanSession("a");

        for (int count = 1; count <= 8; count ++)
        {
            hangman.play(session);
        }

        HangmanState state = (HangmanState) hangman.play(session);

        Assert.assertSame(state.getStatus(), GameStatus.LOST);
    }

    @Test
    void guessWordLoseGame() throws GameSessionException
    {
        playHangman(hangman, "One");
        playHangman(hangman, "Two");
        playHangman(hangman, "Three");
        playHangman(hangman, "Four");
        playHangman(hangman, "Five");
        playHangman(hangman, "Six");
        playHangman(hangman, "Seven");
        playHangman(hangman, "Eight");

        HangmanState state = playHangman(hangman, "Nine");

        Assert.assertSame(state.getStatus(), GameStatus.LOST);
    }

    @Test
    void charGuessWin() throws GameSessionException
    {
        playHangman(hangman, "c");
        playHangman(hangman, "o");
        playHangman(hangman, "m");
        playHangman(hangman, "p");
        playHangman(hangman, "u");
        playHangman(hangman, "t");
        playHangman(hangman, "e");

        HangmanState state = playHangman(hangman, "r");

        Assert.assertSame(state.getStatus(), GameStatus.WON);
    }

    @Test
    void wordGuessWin() throws GameSessionException
    {
        HangmanState state = playHangman(hangman, "computer");
        Assert.assertSame(state.getStatus(), GameStatus.WON);
    }

    @Test
    void multipleGames()
    {

    }

    private HangmanState playHangman(Hangman hangman, String guess) throws GameSessionException
    {
        GameSession session = new HangmanSession(guess);
        return (HangmanState) hangman.play(session);
    }
}