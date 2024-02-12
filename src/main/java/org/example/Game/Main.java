package org.example.Game;

import org.example.Pieces.Knight;
import org.example.Pieces.Piece;
import org.example.Pieces.Rook;

public class Main {
    public static void main(String[] args) {
        Game aloto = new Game();
        aloto.startGame();
        Piece cabasho = new Knight(aloto.getBoard(),new Coordinate('E',4), Knight.Type.BLACK);
        aloto.getBoard().highLight(cabasho.getNextMovements());
        System.out.println(aloto);
        System.out.println(aloto.getDeletedPieces().showDeletedPieces());
    }
}
