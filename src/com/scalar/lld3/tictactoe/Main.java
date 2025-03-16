package com.scalar.lld3.tictactoe;

import com.scalar.lld3.tictactoe.controllers.GameController;
import com.scalar.lld3.tictactoe.models.Board;
import com.scalar.lld3.tictactoe.models.Game;
import com.scalar.lld3.tictactoe.models.GameState;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = GameController.initilizeGame();
        GameController gc = new GameController(game);
        gc.boardController.displayBoard();
        while(game.getGameState().equals(GameState.IN_PROGRESS))
        {
            gc.makeNextMove();
            gc.boardController.displayBoard();
            System.out.println("Do you want to undo the last move? (Y/N)");
            Scanner sc = new Scanner(System.in);
            String ans = sc.next();
            if(ans.equalsIgnoreCase("Y"))
            {
                gc.undoMove();
                gc.boardController.displayBoard();
            }
        }

        gc.boardController.displayBoard();

        if(game.getGameState().equals(GameState.WINNING))
        {
            System.out.println("The winner of the game is " + game.getWinner().getName());
        }
        else
        {
            System.out.println("The game has ended in a draw");
        }
    }
}
