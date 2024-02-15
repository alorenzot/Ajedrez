package org.example.Game;

import org.example.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static Coordinate askCoord(Board board) {
        borrarPantalla();

        System.out.println("Which piece do you want to move? \n" + "Enter a coordinate: \n");
        System.out.println(board.toString());

        Scanner sc = new Scanner(System.in);
        String coord = sc.next();

        if (coord.length() != 2){
            System.out.println("Invalid coordinate, you must introduce a letter and a number [C-2] ");
            return askCoord(board);
        }

        char letter = coord.charAt(0);
        int num = coord.charAt(1) - 48;
        Coordinate c = new Coordinate(letter, num);
        Cell cell = board.getCellAt(c);
        if (board.contains(c) && (!(cell.isEmpty()))) {
            return c;
        } else {
            System.out.println("Invalid coordinate.");
            return askCoord(board);
        }

    }

    public static void askMovement(Board b, Coordinate c){
        Piece p = b.getCellAt(c).getPiece();
        List<Coordinate> list = new ArrayList<>();
        list.addAll(p.getNextMovements());
        b.highLight(list);
        System.out.println(b);
    }
    public static void borrarPantalla() {
        //Este metodo borra la terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
