import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Alienship {
    int input;
    int ship1=3;
    int ship2=3;
    int ship3=3;
    boolean shipkilled=false;
    int pos;
    ArrayList<Integer> shipposition = new ArrayList<Integer>();
    int guess =0;
    public void getinput (int value ){
        input=value;
    }
    public void checkhitmiss() {

        if (shipposition.contains(input)) {

            pos = shipposition.indexOf(input);
                if(pos<3){
                    ship1-=1;
                }
                if(pos>=3 && pos<6 ){
                    ship2-=1;
                }
                if(pos>=6 && pos<9){
                    ship3-=1;
                }

            System.out.println("It is a HIT!!!");

            guess++;

            if(ship1==0){
                System.out.println("Ship 1 is Blasted");
                if (ship1<0){
                    System.out.println("!!!!!!You entered the position twice!!!!!!");
                }

            }
             if(ship2==0){
                 System.out.println("Ship 2 is Blasted");
                 if (ship2<0){
                     System.out.println("!!!!!!You entered the position twice!!!!!!");
                 }

            }
            if(ship3==0){
                System.out.println("Ship 3 is Blasted");
                if (ship3<0){
                    System.out.println("!!!!!!You entered the position twice!!!!!");
                }

            }
            if (ship1==0 && ship2==0 && ship3==0) {
                shipkilled= true;

                System.out.println("You won the GAME!!!!!");
                System.out.println("and the total guess is :" + guess);
            }
        }
        else{
            System.out.println("It is a MISS!!!");
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

    public  void shipSetPosition(){
        int randomship = 0;
        int randomdir = 0;

        for(int i = 0; i < 3; i++) {
            int flag=1;
            randomship = (int) (Math.random() * 64) + 0;
            randomdir = (int) (Math.random() * 2) + 0;
            while(flag==1){

                    if (shipposition.contains(randomship)) {
                        randomship = (int) (Math.random() * 64) + 0;
                    }

                else {
                    flag=0;
                }
            }
            System.out.println("direction: " + randomdir);
            System.out.println(randomship);

            if (randomdir == 0) {
                if ((randomship % 8) == 0) {
                    shipposition.add(randomship);
                    shipposition.add(randomship + 1);
                    shipposition.add(randomship + 2);
//                    System.out.println(randomship + " " + (randomship + 1) + " " + (randomship + 2));
                } else if (((randomship + 1) % 8) == 0) {
                    shipposition.add(randomship - 2);
                    shipposition.add(randomship - 1);
                    shipposition.add(randomship);
//                    System.out.println((randomship - 2) + " " + (randomship - 1) + " " + (randomship ));
                } else {

                    shipposition.add(randomship - 1);
                    shipposition.add(randomship);
                    shipposition.add(randomship + 1);
//                    System.out.println((randomship - 1) + " " + (randomship ) + " " + (randomship + 2));

                }
            }
            else{
                if (randomship < 8){
                    shipposition.add(randomship );
                    shipposition.add(randomship + 8);
                    shipposition.add(randomship + 16);
                    System.out.println(randomship + " " + (randomship + 8) + " " + (randomship + 16));
                }
                else if (randomship > 55){
                    shipposition.add(randomship );
                    shipposition.add(randomship - 8);
                    shipposition.add(randomship - 16);
//                    System.out.println((randomship-16) + " " + (randomship -8) + " " + (randomship ));
                }
                else{
                    shipposition.add(randomship - 8);
                    shipposition.add(randomship );
                    shipposition.add(randomship + 8);
//                    System.out.println((randomship-8) + " " + (randomship ) + " " + (randomship + 8));

                }
            }

            // Output is different everytime this code is executed
        }
        for (int i = 0; i < shipposition.size(); i++) {
            System.out.println(shipposition.get(i));
        }



    }


}