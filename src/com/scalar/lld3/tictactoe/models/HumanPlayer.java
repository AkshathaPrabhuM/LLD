package com.scalar.lld3.tictactoe.models;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, Character symbol, int id) {
        super(name, symbol, id);
    }

    @Override
    public void makeMove() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Whats you move? ");
        int row = sc.nextInt();
        int col = sc.nextInt();


    }
}
