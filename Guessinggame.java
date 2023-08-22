import java.util.Scanner;

public class BinarySearchNumberGuessing {
    public static void Guessingnumbergame() {
        Scanner sc = new Scanner(System.in);
        int low = 1;
        int high = 100;
        int count = 0;
        System.out.println("A number is chosen between 1 to 100.\n" + "Guess the number.");
        while (low <= high) {
            int mid = low + (high - low) / 2; // Use binary search midpoint formula
            count++;
            System.out.println("Is the number " + mid + "? (Enter '1' for correct, '-1' for  high, '0' for low):");
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("Congratulations! your guess is correct.");
                break;
            } else if (n == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low > high) {
            System.out.println("You have exhausted all trials.");
            System.out.println("The number was " + count);
        }

        System.out.println("Number of trials: " + count);
    }
    public static void main(String[] args) {
        Guessingnumbergame();
    }
}
