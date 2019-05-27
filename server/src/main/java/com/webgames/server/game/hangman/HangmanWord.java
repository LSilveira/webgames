package com.webgames.server.game.hangman;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class HangmanWord
{
    private List<Character> characters;

    public boolean validateGuess(String guess)
    {
        return characters.stream()
                .filter(character -> !character.isGuessed())
                .anyMatch(character -> character.isValidGuess(guess));
    }

    public List<String> getCurrentWord()
    {
        return characters.stream().map(Character::getValue).collect(Collectors.toList());
    }

    public boolean isGuessed()
    {
        return characters.stream().noneMatch(character -> character.getValue().equals(Constants.UNKNOW_CHARACTER));
    }

    public boolean isValidWord(String word)
    {
        return characters.stream()
                .map(Character::getChar)
                .collect(Collectors.joining())
                .equalsIgnoreCase(word);
    }
}
