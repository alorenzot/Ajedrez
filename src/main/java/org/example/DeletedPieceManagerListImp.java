package org.example;

import java.util.LinkedList;
import java.util.List;

public class DeletedPieceManagerListImp implements IDeletedPieceManager{

    List<Piece> pieceList;

    public DeletedPieceManagerListImp() {
        this.pieceList = new LinkedList<>();
    }

    @Override
    public void addPiece(Piece piece) {
        pieceList.add(piece);
    }

    @Override
    public Piece removeLast() {
        return pieceList.remove(pieceList.size()-1);
    }

    @Override
    public int count(Piece.Type pieceType) {
//        int pieces=0;
//        for (Piece piece:pieceList){
//            if (piece.getType()==(pieceType)){
//                pieces++;
//            }
//        }
//        return pieces;
        return  (int) pieceList.stream()
                .filter(p->p.getType()==pieceType)
                .count();

    }
}
