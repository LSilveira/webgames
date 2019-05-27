package com.webgames.ui.web;

import com.webgames.ui.client.HangmanClient;
import com.webgames.ui.exception.InvalidRequestException;
import com.webgames.ui.request.GameGuessRequest;
import com.webgames.ui.response.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/game")
public class HangmanController
{
    @Autowired
    private HangmanClient hangmanClient;

    @GetMapping
    public ModelAndView game()
    {
        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

    @GetMapping("/hangman")
    public ModelAndView newHangmanGame(String playerName) throws InvalidRequestException
    {
        ModelAndView mv = new ModelAndView("hangman");

        GameState gameState = hangmanClient.start(playerName);

        mv.addObject("word", String.join(" ", gameState.getWords()));
        mv.addObject("state", gameState.getStatus());
        mv.addObject("playerName", playerName);
        mv.addObject("guessWord", "");
        mv.addObject("totalGuesses", gameState.getTotalGuesses());

        return mv;
    }

    @PostMapping("/hangman")
    public ModelAndView hangmanGame(@RequestBody GameGuessRequest request) throws InvalidRequestException
    {
        ModelAndView mv = new ModelAndView("hangman :: #hangmangTable");

        GameState gameState = hangmanClient.play(request.getPlayerName(), request.getGuessWord());

        mv.addObject("word", String.join(" ", gameState.getWords()));
        mv.addObject("state", gameState.getStatus());
        mv.addObject("playerName", request.getPlayerName());
        mv.addObject("guessWord", "");
        mv.addObject("totalGuesses", gameState.getTotalGuesses());

        return mv;
    }
}
