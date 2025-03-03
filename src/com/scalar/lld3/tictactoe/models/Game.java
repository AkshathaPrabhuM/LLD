package com.scalar.lld3.tictactoe.models;

import com.scalar.lld3.tictactoe.stratergy.ColumnWinningStrategy;
import com.scalar.lld3.tictactoe.stratergy.DiagonalWinningStrategy;
import com.scalar.lld3.tictactoe.stratergy.RowWinningStrategy;
import com.scalar.lld3.tictactoe.stratergy.WinningStrategy;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {

    public Board board;
    List<Player> players;
    public int currentPlayerIndex;
    public List<Cell> moves;
    GameState gameState;
    List<WinningStrategy> winningStrategies;
    Player winner;

    public Game(int n, List<Player> players) {
        this.board = new Board(n);
        this.players = players;
        this.currentPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        winningStrategies = new ArrayList<>(List.of(new RowWinningStrategy(), new ColumnWinningStrategy(), new DiagonalWinningStrategy()));
    }

    public void setWinner() {
        this.winner = this.players.get(this.currentPlayerIndex);
        this.gameState = GameState.WINNING;
    }

    public void setDraw() {
        this.gameState = GameState.DRAW;
    }

    public void makeMoveForCurrPlayer() {
        Player currentPlayer = this.players.get(this.currentPlayerIndex);
        Cell cell = currentPlayer.makeMove();

        // Step 3 update the board and if it fails try again
        try {
            this.board.updateBoard(cell, currentPlayer);
        } catch (IllegalArgumentException e) {
            System.out.println("Please choose a valid move");
            makeMoveForCurrPlayer();
            return;
        }

        this.moves.add(cell);
    }

    public void postMoveWinningCheck() {
        boolean isWin = this.getWinningStrategies().stream().anyMatch(winningStrategy -> winningStrategy.isWinning(this));
        if (isWin) {
            this.setWinner();
        } else {
            // Continue the game
            this.currentPlayerIndex += 1;
            this.currentPlayerIndex %= this.getPlayers().size();
        }
    }

}
