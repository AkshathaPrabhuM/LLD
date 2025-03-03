package com.scalar.lld3.tictactoe.stratergy;

import com.scalar.lld3.tictactoe.models.Cell;
import com.scalar.lld3.tictactoe.models.CellState;
import com.scalar.lld3.tictactoe.models.Game;
import com.scalar.lld3.tictactoe.models.Player;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWinning(Game game) {
        Player currPlayer = game.getPlayers().get(game.currentPlayerIndex);
        Cell cell = game.moves.get(game.moves.size() - 1);
        int row = cell.getRow();
        for(int i=0;i<game.board.getN();i++)
        {
            Cell currCell = game.board.getCells().get(row).get(i);
            if(currCell.getCellState().equals(CellState.NOT_OCCUPIED) || !currCell.getPlayer().equals(currPlayer))
            {
                return false;
            }
        }
        return true;
    }
}
