import java.util.Scanner;

public class AlienshipGameTester {


    public static int[] alienshipsArray = new int[9];
//    public static int[] shipsArray = new int[9];

    public static void gameTester( int [] shiparray  ) {
        Alienship objtest =new Alienship();
        for (int i=0 ;i< 9;i++) {
            objtest.shipposition.add(shiparray[i]);
        }
        for (int l = 0; l < objtest.shipposition.size(); l++) {
            System.out.println(objtest.shipposition.get(l));
        }

    }

    public static void main(String[] args) {
        String guessinput;
        String guessoutput;
        String shippos;

        Alienship test =new Alienship();

        for (int i=0 ;i< 9;i++) {
            // Enter the ship positions

            Scanner coordinate = new Scanner(System.in);
            System.out.println("\n Enter the " + (i+1) +"th ship");
            shippos = coordinate.nextLine();
            alienshipsArray[i]=test.convertRegexToNumber(shippos);


        }
        gameTester(alienshipsArray);
        while(test.shipkilled !=true) {

            // Enter the guess
            Scanner coordinate = new Scanner(System.in);
            System.out.println("\n Enter the Guess value to hit");
            guessinput = coordinate.nextLine();
            
            System.out.println("\n Enter the expected value(hit / miss)");
            guessoutput = coordinate.nextLine();

            //Alpha to digits call
            System.out.println("Guess inputed value");
            int convertedGuessNumber = test.convertRegexToNumber(guessinput);
            test.checkhitmiss(convertedGuessNumber);

            System.out.println("\n\nThe output  should ### " + guessoutput +" ###");

        }
    }
}
