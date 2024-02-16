package org.example.Game;

import org.example.DeletedPieces.DeletedPieceManagerListImp;
import org.example.Pieces.*;

public class Game {
    private Board board;
    private DeletedPieceManagerListImp deletedPieces;
    private boolean playerBlack;
    private boolean gameEnded;

    public DeletedPieceManagerListImp getDeletedPieces() {
        return deletedPieces;
    }

    public Board getBoard() {
        return board;
    }

    public Game() {
        board = new Board();
        deletedPieces = new DeletedPieceManagerListImp();
        gameEnded = false;
        playerBlack = true;
    }

    public void startGame() {
        initBoard();
        System.out.println("Which piece do you want to move? \n");
        Coordinate c = Input.askCoord(this.board);
        Coordinate movement = Input.askMovement(this.board,c);
        //FIXME Al seleccionar una pieca vacía da un mensaje de error, pero al introducir otra no se queja
        if (movement==null) movement = Input.askMovement(this.board,c);


    }

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
        return board.toString();
    }
}
