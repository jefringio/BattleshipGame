import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//        Alienship shipadd = new Alienship();
//        shipadd.shipSetPosition();
//        string layout;
//    }
    public static void main(String[] args) {
        int userinput;
        int xLength = 8;
        int yLength = 8;
        System.out.println("Hello and welcome to Battleship!");
        System.out.println("There are 3 hidden ships.");
        System.out.println("Please enter x and y coordinates (max coordinate of 0-7 ) you would " +
                "like to hit!\n");
        Alienship ship = new Alienship();
        ship.shipSetPosition();

        while(ship.shipkilled !=true) {
            Scanner coordinate = new Scanner(System.in);
            System.out.println("Enter the point to hit");
            userinput = coordinate.nextInt();

            System.out.println(userinput);
            ship.getinput(userinput);
            ship.checkhitmiss();
        }
    }


}
