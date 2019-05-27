package com.webgames.server.game.hangman;

import com.webgames.server.game.GameLogic;
import com.webgames.server.game.GameSession;
import com.webgames.server.game.State;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HangmanLogic implements GameLogic
{
    private HangmanWord hangmanWord;
//    private List<Character> characters;
    private int guesses;
    private State lastState;

    public HangmanLogic(String word)
    {
        hangmanWord = new HangmanWord(
                Arrays.stream(word.split(""))
                        .filter(character -> !character.equals(" "))
                        .map(Character::new)
                        .collect(Collectors.toList())
        );

        guesses = 0;
    }

    @Override
    public State init()
    {
        processState(GameStatus.STARTED);
        return getState();
    }

    @Override
    public State execute(GameSession gameSession) throws GameSessionException
    {
        if ( gameSession == null )
        {
            throw new GameSessionException("Null game session!");
        }

        HangmanState hangmanState = (HangmanState) lastState;

        if ( hangmanState.getStatus().equals(GameStatus.STARTED) )
        {
            if ( guesses < Constants.MAX_GUESSES )
            {
                HangmanSession hangmanSession = (HangmanSession) gameSession;

                //check if the guess is a single character or a word
                if ( hangmanSession.getGuess().length() > 1 )
                {
                    boolean validWord = hangmanWord.isValidWord(hangmanSession.getGuess());

                    if ( validWord )
                    {
                        processState(GameStatus.WON);
                    }
                    else
                    {
                        guesses++;
                        processState(guesses < 9 ? GameStatus.STARTED : GameStatus.LOST);
                    }
                }
                else
                {
                    // check if character was guessed
                    boolean guessed = hangmanWord.validateGuess(hangmanSession.getGuess());

                    if (guessed)
                    {
                        if( hangmanWord.isGuessed() )
                        {
                            processState(GameStatus.WON);
                        }
                        else
                        {
                            processState(GameStatus.STARTED);
                        }
                    }
                    else
                    {
                        guesses++;
                        processState(guesses < 9 ? GameStatus.STARTED : GameStatus.LOST);
                    }
                }
            }
            else
            {
                processState(GameStatus.LOST);
            }
        }

        return getState();
    }

    @Override
    public State state()
    {
        return getState();
    }

    private void processState(GameStatus status)
    {
        lastState = new HangmanState(hangmanWord.getCurrentWord(), status, guesses);
    }

    private State getState()
    {
        return lastState;
    }
}
