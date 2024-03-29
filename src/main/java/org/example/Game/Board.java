package org.example.Game;

import org.example.DeletedPieces.DeletedPieceManagerListImp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Board {

    private Map<Coordinate, Cell> cells;
    private DeletedPieceManagerListImp deletedPieces;

    public Board() {
        boolean classicUI=setColorUI();
        cells = new HashMap<>();
        Coordinate c;
        for (int row = 1; row <= 8; row++) {
            for (char col = 'A'; col <= 'H'; col++) {
                c = new Coordinate(col, row);
                cells.put(c, new Cell(this, c, classicUI));
            }
        }
        deletedPieces = new DeletedPieceManagerListImp();
    }
    public boolean setColorUI(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 0 for classic UI, else for black&white UI");
        String answer = sc.next();
        if (answer.equals("0")) return true;
        else return false;
    }

    public DeletedPieceManagerListImp getDeletedPieces() {
        return deletedPieces;
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

    public void removeHighLight(Collection<Coordinate> coordinates) {
        for (Coordinate c : coordinates)
            getCellAt(c).removeHighLight();
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
        aux += "\t\t    A  B  C  D  E  F  G  H\n";
        aux += deletedPieces.showPieces();

        return aux;
    }
}
