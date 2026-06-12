import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain;
        int totalScore = 0;

        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {
            int targetNumber = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                try {
                    guess = sc.nextInt();
                    attempts++;

                    if (guess == targetNumber) {
                        guessedCorrectly = true;

                        int roundScore = (maxAttempts - attempts + 1) * 10;
                        totalScore += roundScore;

                        System.out.println("\nCongratulations!");
                        System.out.println("You guessed the correct number: " + targetNumber);
                        System.out.println("Attempts Used: " + attempts);
                        System.out.println("Round Score: " + roundScore);
                        break;
                    } 
                    else if (guess < targetNumber) {
                        System.out.println("Too Low! Try Again.");
                    } 
                    else {
                        System.out.println("Too High! Try Again.");
                    }

                    System.out.println("Attempts Remaining: " + (maxAttempts - attempts));

                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input! Please enter an integer.");
                    sc.nextLine(); // Clear invalid input
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n❌ Game Over!");
                System.out.println("The correct number was: " + targetNumber);
            }

            System.out.println("\nCurrent Total Score: " + totalScore);

            System.out.print("\nDo you want to play again? (Y/N): ");
            sc.nextLine(); // Clear buffer
            String choice = sc.nextLine();

            playAgain = choice.equalsIgnoreCase("Y");

        } while (playAgain);

        System.out.println("\n=================================");
        System.out.println("Thank you for playing!");
        System.out.println("Final Score: " + totalScore);
        System.out.println("=================================");

        sc.close();
    }
}
