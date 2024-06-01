import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int totalAttempts = 0;
        int totalRoundsWon = 0;

        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            roundsPlayed++;
            int attempts = 0;
            final int maxAttempts = 10;  // Limiting number of attempts to 10
            int numberToGuess = random.nextInt(100) + 1;

            System.out.println("\nRound " + roundsPlayed);
            System.out.println("You have " + maxAttempts + " attempts to guess the number between 1 and 100.");

            boolean roundWon = false;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                attempts++;
                totalAttempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    totalRoundsWon++;
                    roundWon = true;
                    break;
                }
            }

            if (!roundWon) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("\nGame Over! You've played " + roundsPlayed + " rounds with a total of " + totalAttempts + " attempts.");
        System.out.println("You won " + totalRoundsWon + " out of " + roundsPlayed + " rounds.");
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
