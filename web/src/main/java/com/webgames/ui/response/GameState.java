package com.webgames.ui.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class GameState
{
    private List<String> words;
    private String status;
    private int totalGuesses;
}
