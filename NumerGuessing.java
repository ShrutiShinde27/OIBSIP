// Java program for the above approach
import java.util.Scanner;

public class NumerGuessing {

    public static void guessingNumberGame()
    {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int)(100* Math.random());
        int K;
        int i, guess;

        System.out.println("Welcome to Number Guessing Game!! \nA number is chosen between 1 to 100.");
        System.out.println("\nEnter the number of trials: ");
        K=sc.nextInt();
        

        for (i = 0; i <K; i++) {
            System.out.println("** Round "+i+" **");
            System.out.println( "Guess the number:");
            guess = sc.nextInt();
 
            if (number == guess) {
                System.out.println("Congratulations!!  You guessed the number.");
                break;
            }
            else if (number > guess && i != K-1) {
                System.out.println("Wrong!! The number is greater than " + guess+"\n");
            }
            else if (number < guess && i != K-1) {
                System.out.println("Wrong!! The number is less than " + guess+"\n");
            }
        }
 
        if (i == K) {
            System.out.println("Game Over!! You have exhausted K trials.");
            System.out.println();

            System.out.println("The number was " + number+"!!");
        }
    }
 
    public static void main(String arg[])
    {
        guessingNumberGame();
    }
}
    

