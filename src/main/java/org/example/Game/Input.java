package org.example.Game;

import org.example.Pieces.Piece;

import java.util.*;

/**
 * @author Alejandro Lorenzo Toledo
 */

public class Input {

    /**
     * Este método pregunta al usuario por las coordenadas
     * @param board - Recibe el tablero con el que se va a jugar
     * @param whiteTurn - Indica si es el turno, o no, del jugador blanco para evitar que mueva fichas de otro color
     * @return - Devuelve la coordenada introducida
     */
    public static Coordinate askCoord(Board board, boolean whiteTurn) {
        System.out.println("Enter a coordinate: \n");
        System.out.println(board);

        Scanner sc = new Scanner(System.in);
        String coord = sc.next();


        if (coord.length() != 2 || !Character.isAlphabetic(coord.charAt(0)) || !Character.isDigit(coord.charAt(1))) {
            System.out.println("Invalid coordinate, you must introduce a letter and a number [A-2] ");
            return askCoord(board, whiteTurn);
        }
        char letter = coord.charAt(0);
        int num = coord.charAt(1) - 48;
        Coordinate c = new Coordinate(letter, num);

        if (!board.contains(c)) {
            System.out.println("Invalid coordinate!");
            return askCoord(board, whiteTurn);
        }
        Cell cell = board.getCellAt(c);
        if (cell.isEmpty()) {
            System.out.println("There's no piece in there!");
            return askCoord(board, whiteTurn);
        }
        if (whiteTurn && cell.getPiece().getColor().equals(Piece.Color.BLACK) ||
                !whiteTurn && cell.getPiece().getColor().equals(Piece.Color.WHITE)) {
            System.out.println("You can't move that color.");
            return askCoord(board, whiteTurn);
        }
        if (board.contains(c) && (!(cell.isEmpty()))) {
            System.out.println(cell.getPiece().getType() + " selected.");
            return askMovement(board, c, cell.getPiece().getNextMovements(), whiteTurn);
        } else {
            System.out.println("Invalid coordinate.");
            return askCoord(board, whiteTurn);
        }
    }

    /**
     * Este método muestra los posibles movimientos y pregunta por cuál va a mover
     * @param b - Tablero que se usará
     * @param c - Coordenada de la pieza seleccionada
     * @param nextMovements - Movimientos posibles de la pieza seleccioanda
     * @param whiteTurn - Turno del jugador
     * @return - Devuelve la coordenada devuelta por el metodo makeMove
     * @see #makeMove(Set, Board)
     */
    public static Coordinate askMovement(Board b, Coordinate c, Set<Coordinate> nextMovements, boolean whiteTurn) {
        Piece p = b.getCellAt(c).getPiece();
        Coordinate initial = p.getCell().getCoordinate();

        if (nextMovements.isEmpty()) {
            System.out.println("You can't move that piece!");
            return askCoord(b, whiteTurn);
        }

        b.highLight(nextMovements);
        System.out.println(b);

        Coordinate move = makeMove(nextMovements, b);

        b.getCellAt(c).getPiece().moveTo(move);

        b.removeHighLight(nextMovements);

        System.out.println(p.getType() + " in " + initial + " moved to " + move + "\n");
        if (p.getType().equals(Piece.Type.BLACK_PAWN) && move.getNumber()==1) {
            System.out.println("Black Pawn turned into Black Queen");
            b.getDeletedPieces().addBQueen();
        }
        if (p.getType().equals(Piece.Type.WHITE_PAWN) && move.getNumber()==8) {
            System.out.println("White Pawn turned into White Queen");
            b.getDeletedPieces().addWQueen();
        }

        return move;
    }

    /**
     * Método que mueve la ficha
     * @param movements - movimientos posibles
     * @param board - Tablero de juego
     * @return - Coordenada a la que se moverá
     */
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
        if (board.contains(c) && (!cell.isEmpty()))
            return kill(cell.getPiece());
        if (board.contains(c) && ((cell.isEmpty()))) {
            return c;
        } else {
            System.out.println("Invalid coordinate.");
            return makeMove(movements, board);
        }
    }

    /**
     * Método que mata a otra pieza
     * @param piece - Pieza a matar
     * @return - Coordenada de la pieza matada
     */
    private static Coordinate kill(Piece piece) {
        Game.deletedPieces.addPiece(piece);
        if (piece.getType().equals(Piece.Type.BLACK_KING))
            Game.endGame(true);
        if (piece.getType().equals(Piece.Type.WHITE_KING))
            Game.endGame(false);
        return piece.getCell().getCoordinate();
    }

}

