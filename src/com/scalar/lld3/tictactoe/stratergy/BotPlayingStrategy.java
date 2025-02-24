package com.scalar.lld3.tictactoe.stratergy;

import com.scalar.lld3.tictactoe.models.Board;
import com.scalar.lld3.tictactoe.models.Cell;
import com.scalar.lld3.tictactoe.models.Player;

public interface BotPlayingStrategy {

    Cell suggestMove(Player player, Board board);
}
