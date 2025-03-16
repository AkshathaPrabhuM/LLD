package com.scalar.lld3.tictactoe.stratergy;

import com.scalar.lld3.tictactoe.models.Board;
import com.scalar.lld3.tictactoe.models.Cell;
import com.scalar.lld3.tictactoe.models.CellState;
import com.scalar.lld3.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class MediumBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Cell suggestMove(Player player, Board board) {
        int n = board.getN();
        List<Cell> availableCells = new ArrayList<Cell>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board.getCells().get(i).get(j).getCellState().equals(CellState.NOT_OCCUPIED))
                {
                    availableCells.add(board.getCells().get(i).get(j));
                }
            }
        }
        int x = Math.abs(RandomGenerator.getDefault().nextInt()) % availableCells.size();

        return availableCells.get(x);
    }
}
