package org.example.Game;

import org.example.Pieces.Knight;
import org.example.Pieces.Piece;
import org.example.Pieces.Rook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce white player's name:");
        String white = sc.next();
        System.out.println("Introduce black player's name:");
        String black = sc.next();
        Game aloto = new Game(white, black);
        aloto.startGame();

    }
}