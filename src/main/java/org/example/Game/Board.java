package org.example.Game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Coordinate, Cell> cells;

    public Board() {
        cells = new HashMap<>();
        Coordinate c;
        for (int row = 1; row <= 8; row++) {
            for (char col = 'A'; col <= 'H'; col++) {
                c = new Coordinate(col, row);
                cells.put(c, new Cell(this, c));
            }
        }
    }

    public boolean contains(Coordinate c) {
        return cells.containsKey(c);
    }

    public Cell getCellAt(Coordinate c) {
        return cells.get(c);
    }

    public void highLight(Collection<Coordinate> coordinates) {
        for (Coordinate c : coordinates)
            getCellAt(c).highlight();
    }


    @Override
    public String toString() {
        String aux = "\t\t    A  B  C  D  E  F  G  H\n";
        for (int row = 1; row <= 8; row++) {
            aux += "\t\t " + row + " ";
            for (char col = 'A'; col <= 'H'; col++)
                aux += getCellAt(new Coordinate(col, row));
            aux += " " + row + "\n";
        }
        aux += "\t\t    A  B  C  D  E  F  G  H";
        return aux;
    }
}
