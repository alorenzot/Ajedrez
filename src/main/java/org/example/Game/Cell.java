package org.example.Game;

import com.diogonunes.jcolor.Attribute;
import org.example.Pieces.Piece;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Cell {

    private Piece piece;
    private Board board;
    private Coordinate coordinate;
    private Color originalColor;
    private Color color;
    private boolean classicUI;

    public Cell(Board board, Coordinate coordinate, boolean classicUI) {
        this.board = board;
        this.coordinate = coordinate;
        this.piece = null;

        if ((coordinate.getNumber() + coordinate.getLetter()) % 2 == 1) {
            if (!classicUI) {
                this.originalColor = Color.BLACK;
            }else
                this.originalColor = Color.CLASSICBLACK;
        } else {
            if (!classicUI) {
                this.originalColor = Color.WHITE;
            } else {
                this.originalColor = Color.CLASSICWHITE;
            }
        }
        this.color = originalColor;

    }

    public Piece getPiece() {
        return piece;
    }

    public Board getBoard() {
        return board;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void highlight() {
        if (originalColor == Color.WHITE || originalColor == Color.CLASSICWHITE)
            this.color = (piece != null) ? Color.HIGHLIGHT_KILL_WHITE : Color.HIGHLIGHT_WHITE;
        else
            this.color = (piece != null) ? Color.HIGHLIGHT_KILL_BLACK : Color.HIGHLIGHT_BLACK;

    }

    public void removeHighLight() {
        this.color = originalColor;
    }

    @Override
    public String toString() {
        if (piece == null) {
            return colorize("   ", color.getAttribute());
        } else {
            return colorize(" ", color.getAttribute()) + piece + colorize(" ", color.getAttribute());
        }
    }

    public Color getColor() {
        return color;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public enum Color {
        WHITE(Attribute.BACK_COLOR(180, 180, 180)),
        CLASSICWHITE(Attribute.BACK_COLOR(218,217,181)),

        BLACK(Attribute.BACK_COLOR(100, 100, 100)),
        CLASSICBLACK(Attribute.BACK_COLOR(150,77,34)),
        HIGHLIGHT_KILL_WHITE(Attribute.BACK_COLOR(180, 0, 0)),
        HIGHLIGHT_KILL_BLACK(Attribute.BACK_COLOR(130, 0, 0)),
        HIGHLIGHT_WHITE(Attribute.BACK_COLOR(180, 180, 0)),
        //CLASSIC_HIGHLIGHT_WHITE(Attribute.BACK_COLOR()),
        HIGHLIGHT_BLACK(Attribute.BACK_COLOR(130, 130, 0));
        //CLASSIC_HIGHLIGHT_BLACK(Attribute.BACK_COLOR());


        private Attribute color;

        Color(Attribute color) {
            this.color = color;
        }

        public Attribute getAttribute() {
            return color;
        }

    }
}