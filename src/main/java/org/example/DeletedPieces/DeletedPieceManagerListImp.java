package org.example.DeletedPieces;

import com.diogonunes.jcolor.Attribute;
import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinate;
import org.example.Pieces.*;

import javax.swing.*;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletedPieceManagerListImp implements IDeletedPieceManager {

    MyList<Piece> pieceList;

    public DeletedPieceManagerListImp() {
        this.pieceList = new MyList<>();
    }


    public String showPieces() {
        String output = "\n\t\t\t\tDELETED PIECES\n";
        output+="\t";
        output+=colorize(" ♚ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♛ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♝ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♞ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♜ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♟ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));

        output+=colorize(" ♚ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♛ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♝ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♞ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♜ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♟ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));

        output+="\n\t";
        //Rey, reina, alfil, caballo, torre, peón
        int brey = count(Piece.Type.WHITE_KING);
        int breina = count(Piece.Type.WHITE_QUEEN);
        int balfil = count(Piece.Type.WHITE_BISHOP);
        int bcaballo = count(Piece.Type.WHITE_KNIGHT);
        int btorre = count(Piece.Type.WHITE_ROOK);
        int bpeon = count(Piece.Type.WHITE_PAWN);

        int nrey = count(Piece.Type.BLACK_KING);
        int nreina = count(Piece.Type.BLACK_QUEEN);
        int nalfil = count(Piece.Type.BLACK_BISHOP);
        int ncaballo = count(Piece.Type.BLACK_KNIGHT);
        int ntorre = count(Piece.Type.BLACK_ROOK);
        int npeon = count(Piece.Type.BLACK_PAWN);
        output+=colorize(" "+(brey)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(breina)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(balfil)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(bcaballo)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(btorre)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(bpeon)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(nrey)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(nreina)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(nalfil)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(ncaballo)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(ntorre)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(npeon)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));

        output+= "\n\n\t\t\t\tREMAINING PIECES\n";
        output+="\t";
        output+=colorize(" ♚ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♛ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♝ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♞ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♜ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));
        output+=colorize(" ♟ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(255,255,255));

        output+=colorize(" ♚ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♛ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♝ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♞ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♜ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));
        output+=colorize(" ♟ ", Attribute.BACK_COLOR(100,100,100), Attribute.TEXT_COLOR(0,0,0));

        output+="\n\t";

        output+=colorize(" "+(1-brey)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(1-breina)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(2-balfil)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(2-bcaballo)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(2-btorre)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(8-bpeon)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(1-nrey)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(1-nreina)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(2-nalfil)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(2-ncaballo)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(2-ntorre)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        output+=colorize(" "+(8-npeon)+" ", Attribute.BACK_COLOR(180,180,180), Attribute.TEXT_COLOR(100,100,100));
        return output;
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
