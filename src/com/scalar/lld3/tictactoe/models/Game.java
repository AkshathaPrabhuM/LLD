package com.scalar.lld3.tictactoe.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {

    public Board board;
    List<Player> players;
    int currentPlayerIndex;
    List<Cell> moves;
    GameState gameState;

    public Game(int n, List<Player> players)
    {
        this.board = new Board(n);
        this.players = players;
        this.currentPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
    }
}
