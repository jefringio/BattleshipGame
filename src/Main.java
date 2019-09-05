import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void displayGrid() {
        for(char ch= 'a'; ch< 'i';ch++){
            System.out.println("\n");
            for (int i=0;i<8;i++){
//                String alpha = ch+""+i ;
//                System.out.println(alpha);

                System.out.printf("%c%d  ",ch,i);

            }
        }
    }
    public static void main(String[] args) {
            String userinput;
            int xLength = 8;
            int yLength = 8;
            System.out.println("Hello and welcome to Battleship!");
            System.out.println("There are 3 hidden ships.");
            System.out.println("Please enter x and y coordinates (max coordinate of 0-7 ) you would " +
                    "like to hit!\n");

        // object of ship is created
            Alienship ship = new Alienship();

        // three ships are created
            ship.shipSetPosition();
//            displayGrid('');
//        displayGrid();

            while(ship.shipkilled !=true) {

                // Enter the guess
                    Scanner coordinate = new Scanner(System.in);
                    System.out.println("\n Enter the point to hit");
                    userinput = coordinate.nextLine();

                //Alpha to digits call
                    ship.convertRegexToNumber(userinput);

                // check whether HIT or MISS
                    ship.checkhitmiss();
            }
        }


}
