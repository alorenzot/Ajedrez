package org.example.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce white player's name:");
        String white = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("Introduce black player's name:");
        String black = sc.nextLine();
        Game aloto = new Game(white, black);
        aloto.startGame();

    }
}