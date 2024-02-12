package org.example.Game;

import org.example.Pieces.Piece;

import java.util.Scanner;

public class Input {

    public static Coordinate askCoord(Board board){
        //FIXME No reconoce las coordenadas, probar con matches
        System.out.println("Which piece do you want to move? \n" + "Enter a coordinate: \n");
        System.out.println(board.toString());
        Scanner sc = new Scanner(System.in);
        String coord = sc.nextLine();
        coord.toUpperCase();
        char letter=coord.charAt(0);
        int num = coord.charAt(1);
        Coordinate c;

        if (!(letter<='H' && letter>='A' && num>=1 && num<=8)){
            System.out.println("Please, enter a valid coordinate!");
            return askCoord(board);
        } else c = new Coordinate(coord.charAt(0),coord.charAt(1));

        if (!board.contains(c)){
            System.out.println("Please, enter a valid coordinate!");
            return askCoord(board);
        } else return c;

    }


}
