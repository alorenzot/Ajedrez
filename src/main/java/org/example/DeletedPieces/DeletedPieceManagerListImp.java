package org.example.DeletedPieces;

import org.example.Pieces.Piece;

public class DeletedPieceManagerListImp implements IDeletedPieceManager {

    MyList<Piece> pieceList;

    public DeletedPieceManagerListImp() {
        this.pieceList = new MyList<>();
    }

    @Override
    public void addPiece(Piece piece) {
        pieceList.addHead(piece);
    }

    @Override
    public Piece removeLast() {
        return pieceList.remove(pieceList.size() - 1);
    }

    @Override
    public int count(Piece.Type pieceType) {
        int pieces = 0;
        for (int i = 0; i < pieceList.size(); i++) {
            if (pieceList.get(i).getType() == (pieceType)) {
                pieces++;
            }
        }
        return pieces;
    }
}
