import java.util.Scanner;

public class AlienshipGameTester {
    static String guessoutput;
    static String guessinput;
    public static int[] alienshipsArray = new int[9];


    public static void gameTester( int [] shiparray ,String guessinput , String guessoutput ) {
        Alienship objtest =new Alienship();



        for (int i=0 ;i< 9;i++) {
            if (objtest.shipposition.contains(shiparray[i])==false){
                objtest.shipposition.add(shiparray[i]);
            }
        }
    ////////
//        print values in arraylist
    /////////

        for (int l = 0; l < objtest.shipposition.size(); l++) {
            System.out.println(objtest.shipposition.get(l));
        }



            System.out.println("######Guess value is ");
            int convertedGuessNumber = objtest.convertRegexToNumber(guessinput);
            objtest.checkhitmiss(convertedGuessNumber);

//            System.out.println("\n\nThe output  should ### " + guessoutput +" ###");
            if (guessoutput.equals("hit")) {
                if (objtest.testpass==1) {
                    System.out.println("Testcase PASSED");
//                    objtest.shipkilled=true;

                }
                else {
                    System.out.println("Testcase FAILED");
//                   objtest.shipkilled=true;
                }
            }
            else if (guessoutput.equals("miss")) {
                if (objtest.testpass==0) {
                    System.out.println("Testcase PASSED");
//                    objtest.shipkilled=true;
                }
                else {
                    System.out.println("Testcase FAILED");
//                    objtest.shipkilled=true;
                }
            }
            else
                System.out.println("You entered wrong input");
        }



    public static void main(String[] args) {

        String shippos;
        Alienship test =new Alienship();

        for (int i=0 ;i< 9;i++) {
            // Enter the ship positions

            Scanner coordinate = new Scanner(System.in);
            System.out.println("\n Enter the " + (i+1) +"th ship");
            shippos = coordinate.nextLine();
            alienshipsArray[i]=test.convertRegexToNumber(shippos);
        }


        while(test.shipkilled !=true) {
            test.shipkilled=false;
            Scanner coordinate = new Scanner(System.in);
            System.out.println("\n Enter the Guess value to hit");
            guessinput = coordinate.nextLine();

            System.out.println("\n Enter the expected value(hit / miss)");
            guessoutput = coordinate.nextLine();

            gameTester(alienshipsArray, guessinput, guessoutput);
        }

    }
}
