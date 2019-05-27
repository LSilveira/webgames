package com.webgames.ui.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GameGuessRequest
{
    private String playerName;
    private String guessWord;
}
