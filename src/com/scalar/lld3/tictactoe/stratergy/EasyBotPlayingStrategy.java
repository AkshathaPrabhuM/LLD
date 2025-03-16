package com.scalar.lld3.tictactoe.stratergy;

import com.scalar.lld3.tictactoe.models.Board;
import com.scalar.lld3.tictactoe.models.Cell;
import com.scalar.lld3.tictactoe.models.CellState;
import com.scalar.lld3.tictactoe.models.Player;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Cell suggestMove(Player player, Board board) {
        int N = board.getN();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Cell cell = board.getCells().get(i).get(j);
                if(cell.getCellState().equals(CellState.NOT_OCCUPIED))
                {
                    return cell;
                }
            }
        }
        throw new IllegalStateException("No space on board");
    }
}
