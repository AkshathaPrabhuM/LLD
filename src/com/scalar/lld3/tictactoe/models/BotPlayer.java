package com.scalar.lld3.tictactoe.models;

import com.scalar.lld3.tictactoe.stratergy.BotPlayingStrategyFactory;
import com.scalar.lld3.tictactoe.stratergy.BotPlayingStrategy;

public class BotPlayer extends Player {

    BotDifficultyLevel difficultyLevel;

    BotPlayingStrategy strategy;

    public BotPlayer(String name, Character symbol, int id, BotDifficultyLevel difficultyLevel) {
        super(name, symbol, id);
        this.difficultyLevel = difficultyLevel;
        this.strategy = BotPlayingStrategyFactory.getBotPlayingStratergy(difficultyLevel);
    }

    @Override
    public Cell makeMove(Board board, Player player) {
        return strategy.suggestMove(player, board);
    }
}
