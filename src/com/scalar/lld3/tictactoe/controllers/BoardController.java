package com.scalar.lld3.tictactoe.controllers;

import com.scalar.lld3.tictactoe.models.Board;
import com.scalar.lld3.tictactoe.models.Cell;
import com.scalar.lld3.tictactoe.models.CellState;
import com.scalar.lld3.tictactoe.models.Player;

public class BoardController {

    Board board;
    int N;

    BoardController(Board board) {
        this.board = board;
        this.N = board.getN();
    }

    public void displayBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board.getCells().get(i).get(j).getCellState().equals(CellState.OCCUPIED)) {
                    System.out.printf("| %c ", board.getCells().get(i).get(j).getPlayer().getSymbol());
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
    }

    public void updateBoard(Cell cell, Player player) {
        int row = cell.getRow();
        int col = cell.getColumn();

        if (row < N && col < N && row >= 0 && col >= 0 && this.board.getCells().get(row).get(col).getCellState().equals(CellState.NOT_OCCUPIED)) {
            this.board.getCells().get(row).get(col).updateCell(player);
        } else {
            throw new IllegalArgumentException("The move is invalid");
        }
    }

    public boolean isFull() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Cell cell = board.getCells().get(i).get(j);
                if (cell.getCellState().equals(CellState.NOT_OCCUPIED)) {
                    return false;
                }
            }
        }
        return true;
    }
}
