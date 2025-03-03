package com.scalar.lld3.tictactoe.controllers;

import com.scalar.lld3.tictactoe.models.Cell;
import com.scalar.lld3.tictactoe.models.Game;
import com.scalar.lld3.tictactoe.models.HumanPlayer;
import com.scalar.lld3.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public static Game initilizeGame() {

        System.out.println("Enter board size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Enter player name and the symbol: ");
            String playerName = sc.next();
            String symbol = sc.next();
            players.add(new HumanPlayer(playerName, symbol.charAt(0), i + 1));

        }
        return new Game(n, players);
    }

    public void makeNextMove() {
        if(game.board.isFull())
        {
            game.setDraw();
            return;
        }

        // Step 1
        int currentPlayerIndex = game.getCurrentPlayerIndex();
        Player currentPlayer = game.getPlayers().get(currentPlayerIndex);

        // Step 2
        System.out.println("It's " + currentPlayer.getName() + "'s move");
        game.makeMoveForCurrPlayer();

        // Step 4 - Check for winning strategies
        game.postMoveWinningCheck();
    }
}
