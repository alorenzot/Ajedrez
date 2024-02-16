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

        if (coord.length() != 2) {
            System.out.println("Invalid coordinate, you must introduce a letter and a number [C-2] ");
            return askCoord(board);
        }
        char letter = coord.charAt(0);
        int num = coord.charAt(1) - 48;
        Coordinate c = new Coordinate(letter, num);

        Cell cell = board.getCellAt(c);

        if (board.contains(c) && (!(cell.isEmpty()))) {
            System.out.println(cell.getPiece().getType() + " selected.");
            return askMovement(board,c,cell.getPiece().getNextMovements());
        } else {
            System.out.println("Invalid coordinate.");
            return askCoord(board);
        }


    }

    public static Coordinate askMovement(Board b, Coordinate c, Set<Coordinate> nextMovements) {
        Piece p = b.getCellAt(c).getPiece();
        Piece aux = p;
        Set<Coordinate> movements = nextMovements;

        if (movements.isEmpty()){
            System.out.println("You can't move that piece!");
            return askCoord(b);
        }

        b.highLight(movements);
        System.out.println(b);

        Coordinate move = makeMove(movements, b);

        b.getCellAt(p.getCell().getCoordinate()).setPiece(null);
        aux.setCell(b.getCellAt(move));
        b.getCellAt(move).setPiece(aux);
        b.removeHighLight(movements);

        System.out.println(aux.getType() + " in " + aux.getCell().getCoordinate() + " moved to " + move);

        System.out.println(b);

        return null;
    }

    private static Coordinate makeMove(Set<Coordinate> movements, Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Possible movements: \n" + movements);
        System.out.println("Type the wished coordinate.");
        String coord = sc.next();

        if (coord.length() != 2) {
            System.out.println("Invalid coordinate, you must introduce a letter and a number [C-2] ");
            return makeMove(movements, board);
        }

        char letter = coord.charAt(0);
        int num = coord.charAt(1) - 48;
        Coordinate c = new Coordinate(letter, num);

        //Check if the selected coordinate is in the list
        if (!(movements.contains(c))) {
            System.out.println("You can't move there!");
            return makeMove(movements, board);
        }

        Cell cell = board.getCellAt(c);
        if (board.contains(c) && ((cell.isEmpty()))) {
            return c;
        } else {
            System.out.println("Invalid coordinate.");
            return makeMove(movements, board);
        }
    }

    public static void borrarPantalla() {
        //Este metodo borra la terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
