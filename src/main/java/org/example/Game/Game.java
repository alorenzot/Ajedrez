package org.example.Game;

import org.example.DeletedPieces.DeletedPieceManagerListImp;
import org.example.Pieces.*;

/**
 * @author Alejandro Lorenzo Toledo
 */

public class Game {
    private Board board;
    public static DeletedPieceManagerListImp deletedPieces;
    private String whitePlayer;
    private String blackPlayer;
    private static boolean playerBlackWins;
    public static boolean gameEnded;

    /**
     * Finaliza el juego
     * @param blackwins - booleano que indica si el jugador ganador es el negro
     */
    public static void endGame(Boolean blackwins) {
        playerBlackWins = blackwins;
        gameEnded = true;
    }
    public Board getBoard() {
        return board;
    }

    public Game(String whitePlayer, String blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        board = new Board();
        deletedPieces = board.getDeletedPieces();
        gameEnded = false;
        playerBlackWins = true;
    }

    /**
     * Método que inicia el juego
     */

    public void startGame() {
        int movements=0;
        initBoard();
        for (int i = 0; !gameEnded; i++) {
            boolean whiteTurn;
            if (i % 2 == 0) {
                whiteTurn = true;
                System.out.println(whitePlayer + "'s turn -> WHITE");
            } else {
                whiteTurn = false;
                System.out.println(blackPlayer + "'s turn -> BLACK");
            }
            System.out.println("Which piece do you want to move?");

            Input.askCoord(this.board, whiteTurn);

            movements++;
        }
        if (!playerBlackWins) {
            System.out.println("Black player - " + blackPlayer + " - wins!");
        } else {
            System.out.println("White player - " + whitePlayer + " - wins!");
        }
        System.out.println("Total made movements: " + movements);

    }

    /**
     * Método que coloca las fichas en el tablero
     */
    private void initBoard() {

        //Filling whites
        Piece whiteRook = new Rook(board, new Coordinate('A', 1), Rook.Type.WHITE);
        Piece whiteRook2 = new Rook(board, new Coordinate('H', 1), Rook.Type.WHITE);
        Piece whiteKnight = new Knight(board, new Coordinate('B', 1), Knight.Type.WHITE);
        Piece whiteKnight2 = new Knight(board, new Coordinate('G', 1), Knight.Type.WHITE);
        Piece whiteBishop = new Bishop(board, new Coordinate('C', 1), Bishop.Type.WHITE);
        Piece whiteBishop2 = new Bishop(board, new Coordinate('F', 1), Bishop.Type.WHITE);
        Piece whiteKing = new King(board, new Coordinate('D', 1), King.Type.WHITE);
        Piece whiteQueen = new Queen(board, new Coordinate('E', 1), Queen.Type.WHITE);
        for (char i = 0; i <= 8; i++) {
            Piece pawn = new Pawn(board, new Coordinate(((char) ('A' + i)), 2), Pawn.Type.WHITE);
        }

        //Filling blacks
        Piece blackRook = new Rook(board, new Coordinate('A', 8), Rook.Type.BLACK);
        Piece blackRook2 = new Rook(board, new Coordinate('H', 8), Rook.Type.BLACK);
        Piece blackKnight = new Knight(board, new Coordinate('B', 8), Knight.Type.BLACK);
        Piece blackKnight2 = new Knight(board, new Coordinate('G', 8), Knight.Type.BLACK);
        Piece blackBishop = new Bishop(board, new Coordinate('C', 8), Bishop.Type.BLACK);
        Piece blackBishop2 = new Bishop(board, new Coordinate('F', 8), Bishop.Type.BLACK);
        Piece blackKing = new King(board, new Coordinate('D', 8), King.Type.BLACK);
        Piece blackQueen = new Queen(board, new Coordinate('E', 8), Queen.Type.BLACK);
        for (char i = 0; i < 8; i++) {
            Piece pawn2 = new Pawn(board, new Coordinate(((char) ('A' + i)), 7), Pawn.Type.BLACK);
        }


    }

    @Override
    public String toString() {
        return board.toString() + deletedPieces;
    }

}
