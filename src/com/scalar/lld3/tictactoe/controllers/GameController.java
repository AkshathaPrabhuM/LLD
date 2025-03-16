package com.scalar.lld3.tictactoe.controllers;

import com.scalar.lld3.tictactoe.models.*;

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
            players.add(getPlayerInfoFromUser(i));
        }
        return new Game(n, players);
    }

    private static Player getPlayerInfoFromUser(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player name and the symbol: ");
        String playerName = sc.next();
        String symbol = sc.next();
        System.out.println("Is it a bot player ? (Y/N): ");
        String botPlayer = sc.next();
        if (botPlayer.equalsIgnoreCase("Y")) {
            System.out.println("Enter the difficulty: (1/2/3) : ");
            int difficulty = sc.nextInt();
            BotDifficultyLevel botDifficultyLevel = switch (difficulty) {
                case 1 -> BotDifficultyLevel.EASY;
                case 2 -> BotDifficultyLevel.MEDIUM;
                default -> BotDifficultyLevel.HARD;
            };
            return new BotPlayer(playerName, symbol.charAt(0), i + 1, botDifficultyLevel);
        }
        return new HumanPlayer(playerName, symbol.charAt(0), i + 1);
    }

    public void makeNextMove() {
        if (game.board.isFull()) {
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
