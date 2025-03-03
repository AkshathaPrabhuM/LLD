package com.scalar.lld3.tictactoe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {

    int N;

    List<List<Cell>> cells = new ArrayList<>();

    public Board(int N) {
        if (N < 3) {
            throw new IllegalArgumentException("Number of boards must be greater than 3");
        }
        this.N = N;
        for (int i = 0; i < N; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j = 0; j < N; j++) {
                row.add(new Cell(i, j));
            }
            cells.add(row);
        }
    }

    public void displayBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cells.get(i).get(j).cellState.equals(CellState.OCCUPIED)) {
                    System.out.printf("| %c ", cells.get(i).get(j).player.symbol);
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
    }

    public void updateBoard(Cell cell, Player player) {
        int row = cell.row;
        int col = cell.column;

        if (row < N && col < N && row >= 0 && col >= 0 && this.cells.get(row).get(col).cellState.equals(CellState.NOT_OCCUPIED)) {
            this.cells.get(row).get(col).updateCell(player);
        } else {
            throw new IllegalArgumentException("The move is invalid");
        }
    }

    public boolean isFull() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Cell cell = cells.get(i).get(j);
                if (cell.cellState.equals(CellState.NOT_OCCUPIED)) {
                    return false;
                }
            }
        }
        return true;
    }
}
