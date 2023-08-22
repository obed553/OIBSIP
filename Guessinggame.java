import java.util.Scanner;

public class NumberGuessing {
    // Function that implements the number guessing game
    public static void guessingNumberGame() {
        // Scanner Class
        Scanner sc = new Scanner(System.in);
        
        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = (int) (Math.random() * 100) + 1; // Generate the target number
        int guess;
        int trials = 0;
        
        System.out.println("A number is chosen between 1 to 100.\n" + "Guess the number.");

        // Binary search-based guessing loop
        while (true) {
            guess = (lowerBound + upperBound) / 2; // Guess the middle number
            trials++;

            System.out.println("Is the number " + guess + "? (Enter '1' for correct, '-1' for too high, '0' for too low):");
            int response = sc.nextInt();

            if (response == 1) {
                System.out.println("Congratulations! You guessed the number.");
                break;
            } else if (response == -1) {
                upperBound = guess - 1; // Adjust the upper bound
            } else {
                lowerBound = guess + 1; // Adjust the lower bound
            }

            if (lowerBound > upperBound) {
                System.out.println("You have exhausted all trials.");
                System.out.println("The number was " + targetNumber);
                break;
            }
        }
        
        System.out.println("Number of trials: " + trials);
    }

    // Driver Code
    public static void main(String[] args) {
        // Function Call
        guessingNumberGame();
    }
}
