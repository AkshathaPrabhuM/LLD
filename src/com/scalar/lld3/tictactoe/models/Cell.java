package com.scalar.lld3.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    int row;

    int column;

    Player player;

    CellState cellState;

    public Cell(int row, int column)
    {
        this.row = row;
        this.column = column;
        this.cellState = CellState.NOT_OCCUPIED;
    }

    public void updateCell(Player player)
    {
        this.player = player;
        this.cellState = CellState.OCCUPIED;
    }
}
