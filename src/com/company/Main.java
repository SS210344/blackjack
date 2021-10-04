package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int min = 2;
        int max = 11;

        String play = "y";
        double cash = 100;
        while (play.equals("y")) {
            // betting
            double bet ;
            System.out.println("how much do you want to bet odds 3 to 2 \n ");
            System.out.println("currently have "+cash );
            while (true) {

                bet = input.nextDouble();
                if( (bet <= cash)&& (bet >= 0 )){
                    break;
                }
                else{
                    System.out.println("bet exceed current cash or less than zero");
                }

            }


            int userScore ;
            int compScore ;
            int card ;

            // dealer first card

            compScore = drawCard(min, max);
            System.out.println("dealers first card is " + compScore +"\n");

            // user cards to start

            userScore = drawCard(min, max);
            System.out.println("player first card is " + userScore +"\n");
            card = drawCard(1, 11);
            System.out.println("player second card is " + card +"\n");
            userScore = userScore + card;
            System.out.println("player total  is " + userScore +"\n");

            // users go

            while (userScore < 21) {
                System.out.println("player hit of stick ");
                String decition = input.next();
                if (decition.equalsIgnoreCase("hit")) {
                    card = drawCard(min, max);
                    System.out.println("\n player card is " + card +"\n");
                    userScore = userScore + card;
                    System.out.println("player total  is " + userScore +"\n");
                }
                if (decition.equalsIgnoreCase("stick")) {
                    System.out.println("player final  is " + userScore +"\n");
                    break;
                }
            }
            // dealers second card

            card = drawCard(min, max);
            System.out.println("\n");
            System.out.println("dealer second card is " + card +"\n");
            compScore = compScore + card;
            System.out.println("dealer total  is " + compScore +"\n");

            // dealer draws to 17

            while (compScore < 17) {
                card = drawCard(min, max);
                System.out.println("dealer card is " + card +"\n");
                compScore = compScore + card;
                System.out.println("dealer total  is " + compScore +"\n");
            }
            System.out.println("dealer final score is " + compScore +"\n");

            System.out.println("player final  is " + userScore +"\n");

            // decided the winner and pay out
            double winnings = 0;
            if (userScore > 21) {
                System.out.println("player gone bust\n");
                System.out.println("dealer wins\n");


            } else if (compScore > 21) {
                System.out.println("dealer gone bust\n");
                System.out.println("player wins\n");
                winnings = bet *1.5;

            } else if (userScore > compScore) {
                System.out.println("player wins\n");
                winnings= bet *1.5;

            } else {
                System.out.println("dealer wins\n");

            }
            System.out.println("you won "+winnings +"\n");
            cash = cash- bet;
            cash= cash + winnings;
            System.out.println("new total cash is "+cash +"\n");

            // what to go again
            while (true) {
                System.out.println("play again y/n");
                String decition = input.next();
                if (decition.equalsIgnoreCase("n")){
                    play = "n";
                    break;
                }if (decition.equalsIgnoreCase("Y")) {
                    break;
                }
            }

        }





    }
    public static int drawCard(int min , int max)
    {Random randNum = new Random();

        return randNum.nextInt(max - min )+min ;

    }


}
