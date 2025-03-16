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
}
