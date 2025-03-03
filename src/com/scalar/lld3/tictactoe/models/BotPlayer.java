package com.scalar.lld3.tictactoe.models;

public class BotPlayer extends Player {

    BotDifficultyLevel difficultyLevel;

    public BotPlayer(String name, Character symbol, int id, BotDifficultyLevel difficultyLevel) {
        super(name, symbol, id);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Cell makeMove() {

        return null;
    }
}
