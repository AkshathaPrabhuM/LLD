package com.scalar.lld3.tictactoe;

import com.scalar.lld3.tictactoe.controllers.GameController;
import com.scalar.lld3.tictactoe.models.Board;
import com.scalar.lld3.tictactoe.models.Game;
import com.scalar.lld3.tictactoe.models.GameState;

public class Main {

    public static void main(String[] args) {
        Game game = GameController.initilizeGame();
        GameController gc = new GameController(game);
        while(game.getGameState().equals(GameState.IN_PROGRESS))
        {
            game.getBoard().displayBoard();
            gc.makeNextMove();
        }

        game.getBoard().displayBoard();
    }
}
