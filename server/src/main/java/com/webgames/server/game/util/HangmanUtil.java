package com.webgames.server.game.util;

import com.webgames.server.game.config.GameConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Handman util tool
 */
public class HangmanUtil
{
    private static HangmanUtil instance;

    private static GameConfig gameConfig;

    private static Random rand = new Random();

    private HangmanUtil()
    {
    }

    public static HangmanUtil getInstance()
    {
        if (instance == null)
        {
            instance = new HangmanUtil();
            gameConfig = BeanUtil.getBean(GameConfig.class);
            rand = new Random();
        }

        return instance;
    }

    /**
     * Generates a random words
     * @return words
     */
    public String generateRandomWord()
    {
        int numberOfWords = gameConfig.getWords().size();
        int randomIndex = rand.nextInt(numberOfWords);
        return gameConfig.getWords().get(randomIndex);
    }
}
