package com.scalar.lld3.tictactoe.stratergy;

import com.scalar.lld3.tictactoe.models.Cell;
import com.scalar.lld3.tictactoe.models.CellState;
import com.scalar.lld3.tictactoe.models.Game;
import com.scalar.lld3.tictactoe.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWinning(Game game) {
        return leftTopToRightBottomCheck(game) || rightBottomToLEftTopCheck(game);
    }

    public boolean leftTopToRightBottomCheck(Game game)
    {
        Player currPlayer = game.getPlayers().get(game.currentPlayerIndex);

        for(int i=0;i<game.board.getN();i++)
        {
            Cell currCell = game.board.getCells().get(i).get(i);
            if(currCell.getCellState().equals(CellState.NOT_OCCUPIED) || !currCell.getPlayer().equals(currPlayer))
            {
                return false;
            }
        }
        return true;
    }

    public boolean rightBottomToLEftTopCheck(Game game)
    {
        Player currPlayer = game.getPlayers().get(game.currentPlayerIndex);

        int N = game.board.getN();

        for(int i=0;i<N;i++)
        {
            Cell currCell = game.board.getCells().get(i).get(N-i-1);
            if(currCell.getCellState().equals(CellState.NOT_OCCUPIED) || !currCell.getPlayer().equals(currPlayer))
            {
                return false;
            }
        }
        return true;
    }
}
