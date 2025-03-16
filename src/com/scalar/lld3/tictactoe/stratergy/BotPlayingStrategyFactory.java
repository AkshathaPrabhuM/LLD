package com.scalar.lld3.tictactoe.stratergy;

import com.scalar.lld3.tictactoe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStratergy(BotDifficultyLevel difficultyLevel) {
        return switch (difficultyLevel) {
            case EASY -> new EasyBotPlayingStrategy();
            default -> new MediumBotPlayingStrategy();
        };
    }
}
