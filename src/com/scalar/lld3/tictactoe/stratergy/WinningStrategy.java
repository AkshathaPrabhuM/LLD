package com.scalar.lld3.tictactoe.stratergy;

import com.scalar.lld3.tictactoe.models.Game;

public interface WinningStrategy {

    boolean isWinning(Game game);
}
