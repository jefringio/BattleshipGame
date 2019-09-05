
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Alienship {
    int input;
    int[] temparray = new int[3];
    boolean shipkilled=false;
    int pos;
    int guess =0;
    int invalidguess =0;

    ArrayList<Integer> shipposition = new ArrayList<Integer>();
    ArrayList<Integer> ship1 = new ArrayList<Integer>();
    ArrayList<Integer> ship2 = new ArrayList<Integer>();
    ArrayList<Integer> ship3 = new ArrayList<Integer>();


    public void getinput (int value ){
        input=value;
    }

    public void checkhitmiss() {

        if (shipposition.contains(input)) {

            pos = shipposition.indexOf(input);
            if (pos < 3) {
                if (ship1.contains(input)) {
                    System.out.println("You already entered " + input + ".");
                    invalidguess++;
                }
                else {
                    ship1.add(input);
                    System.out.println("hit");
                    guess++;
                }
                if(ship1.size()==3 ) {
                    System.out.println("!!!Ship-1 sunk!!!");
                }
            }
            else if (pos >= 3 && pos < 6) {
                if (ship2.contains(input)) {
                    System.out.println("You already entered " + input + ".");
                    invalidguess++;
                }
                else {
                    ship2.add(input);
                    System.out.println("hit");
                    guess++;
                }
                if(ship2.size()==3 ) {
                    System.out.println("!!!Ship-2 sunk!!!");
                }
            }
            else if (pos >= 6 && pos < 9) {
                if (ship3.contains(input)) {
                    System.out.println("You already entered " + input + ".");
                    invalidguess++;
                }
                else {
                    ship3.add(input);
                    System.out.println("hit");
                    guess++;
                }
                if(ship3.size()==3 ) {
                    System.out.println("!!!Ship-3 sunk!!!");
                }
            }
            if((ship1.size()==3 ) && (ship2.size()==3) &&(ship3.size()==3)){
                shipkilled= true;
                System.out.println("You won the GAME!!!!!");
                System.out.println("and the total valid guesses are : " + (guess));
                System.out.println("and the total guesses with multiple entry are : " + (guess+invalidguess));
            }
        }
        else{
            System.out.println("miss");
            guess++;
        }
    }

//    public void convertRegexToNumber (String value ){
//        boolean b = Pattern.matches("[a-h|A-H][1-8]" , value);
//        String[] firststring=value.split("(?!^)");
//        firststring[0]
//
//        }
//
//
//    }

    public  void shipSetPosition() {
        int randomship = 0;
        int randomdir = 0;


        for (int i = 0; i < 4; i++) {

            boolean flag = true;
            randomship = (int) (Math.random() * 64) + 0;
            randomdir = (int) (Math.random() * 2) + 0;

            while (flag) {
                if ((temparray[0] != 0) && (temparray[1] != 0) && (temparray[2] != 0)) {
                    if (shipposition.contains(temparray[0]) == false && shipposition.contains(temparray[1]) == false
                            && shipposition.contains(temparray[2]) == false) {

                        shipposition.add(temparray[0]);
                        shipposition.add(temparray[1]);
                        shipposition.add(temparray[2]);
                    } else {
                        randomship = (int) (Math.random() * 64) + 0;
                        if (shipposition.contains(randomship)) {
                            flag = true;

                        } else
                            flag = false;

                    }
                }
                else{
                    flag=false;
                }
            }
            System.out.println("direction: " + randomdir);
            System.out.println("umer: "+ randomship);

            if (randomdir == 0) {
                if ((randomship % 8) == 0) {
                    temparray[0] = randomship;
                    temparray[1] = randomship + 1;
                    temparray[2] = randomship + 1;

                } else if (((randomship + 1) % 8) == 0) {

                    temparray[0] = randomship - 2;
                    temparray[1] = randomship - 1;
                    temparray[2] = randomship;

                } else {
                    temparray[0] = randomship - 1;
                    temparray[1] = randomship;
                    temparray[2] = randomship + 1;

                }
            } else {
                if (randomship < 8) {
                    temparray[0] = randomship;
                    temparray[1] = randomship + 8;
                    temparray[2] = randomship + 16;

                } else if (randomship > 55) {
                    temparray[0] = randomship - 16;
                    temparray[1] = randomship - 8;
                    temparray[2] = randomship;

                } else {
                    temparray[0] = randomship - 8;
                    temparray[1] = randomship;
                    temparray[2] = randomship + 8;


                }
            }

            // Insert the the random values into array list

            if ((temparray[0] == 0) && (temparray[1] == 0) && (temparray[2] == 0)) {
                if (shipposition.contains(temparray[0]) == false && shipposition.contains(temparray[1]) == false
                        && shipposition.contains(temparray[2]) == false) {

                    shipposition.add(temparray[0]);
                    shipposition.add(temparray[1]);
                    shipposition.add(temparray[2]);
                }
            }

            for (int l = 0; l < shipposition.size(); l++) {
                System.out.println(shipposition.get(l));
            }
        }
    }
}

