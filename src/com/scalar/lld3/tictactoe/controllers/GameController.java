package com.scalar.lld3.tictactoe.controllers;

import com.scalar.lld3.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    Game game;
    public BoardController boardController;

    public GameController(Game game) {
        this.game = game;
        this.boardController = new BoardController(game.board);
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
        if (boardController.isFull()) {
            game.setDraw();
            return;
        }

        // Step 1
        int currentPlayerIndex = game.getCurrentPlayerIndex();
        Player currentPlayer = game.getPlayers().get(currentPlayerIndex);

        // Step 2
        System.out.println("It's " + currentPlayer.getName() + "'s move");
        makeMoveForCurrPlayer();

        // Step 4 - Check for winning strategies
        postMoveWinningCheck();
    }

    public void undoMove() {
        // Step 1 remove the move from history
        Cell cell = game.moves.get(game.moves.size() - 1);
        game.moves.remove(game.moves.size() - 1);

        // Updating the board without the cell
        Cell removeCell = game.board.getCells().get(cell.getRow()).get(cell.getColumn());
        removeCell.setPlayer(null);
        removeCell.setCellState(CellState.NOT_OCCUPIED);

        // reset the current player
        game.currentPlayerIndex = (this.game.currentPlayerIndex - 1 + game.getPlayers().size()) % game.getPlayers().size();
    }

    private void makeMoveForCurrPlayer() {
        Player currentPlayer = this.game.getPlayers().get(this.game.currentPlayerIndex);
        Cell cell = currentPlayer.makeMove(game.board, currentPlayer);

        // Step 3 update the board and if it fails try again
        try {
            this.boardController.updateBoard(cell, currentPlayer);
            this.game.getMoves().add(cell);
        } catch (IllegalArgumentException e) {
            System.out.println("Please choose a valid move");
            makeMoveForCurrPlayer();
        }
    }

    private void postMoveWinningCheck() {
        boolean isWin = game.getWinningStrategies().stream().anyMatch(winningStrategy -> winningStrategy.isWinning(game));
        if (isWin) {
            game.setWinner();
        } else {
            // Continue the game
            game.currentPlayerIndex += 1;
            game.currentPlayerIndex %= game.getPlayers().size();
        }
    }
}
