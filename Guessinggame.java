import java.util.Scanner;

public class guessingGame {
    public static void main(String[] args) {
        int computeNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        int count = 1;
        
        try (Scanner scanner = new Scanner(System.in)) {
            while (userAnswer != computeNumber) {
                System.out.print("Enter a guess between 1 and 100: ");
                userAnswer = scanner.nextInt();
                System.out.println(determineGuess(userAnswer, computeNumber, count));
                count++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Method to determine the guess result
    public static String determineGuess(int userAnswer , int computeNumber , int count) {
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computeNumber) {
            return "Correct! \nTotal Guesses: " + count;
        } else if (userAnswer > computeNumber) {
            return "Your guess is too high, try again. \nTry Number: " + count;
        } else if (userAnswer < computeNumber) {
            return "Your guess is too low, try again. \nTry Number: " + count;
        } else {
            return "Your guess is incorrect. \nTry Number: " + count;
        }
    }
}
