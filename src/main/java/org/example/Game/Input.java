package org.example.Game;

import org.example.Pieces.Pawn;
import org.example.Pieces.Piece;

import java.util.*;

public class Input {

    public static Coordinate askCoord(Board board) {
        borrarPantalla();

        System.out.println("Enter a coordinate: \n");
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
            System.out.println(cell.getPiece().getType()+" selected.");
            return c;
        } else {
            System.out.println("Invalid coordinate.");
            return askCoord(board);
        }

    }

    public static void askMovement(Board b, Coordinate c) {
        Set<Coordinate> movements = new HashSet<>();
        Piece p = b.getCellAt(c).getPiece();

        movements.addAll(p.getNextMovements());
        b.highLight(movements);

        System.out.println("Here are the moves you can do: \n" + movements);
        System.out.println(b);
        //TODO Método para preguntar coordenadas en base a la pieza elegida
        //TODO cambiar el metodo para que devuelva la coordenada elegida
        //TODO implementar movimiento
        //FIXME Los peones negros no pueden avanzar 2 casillas al inicio

    }
    public static void borrarPantalla() {
        //Este metodo borra la terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
