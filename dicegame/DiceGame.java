import java.util.Scanner;
import java.util.Random;

/**
 * DiceGame class to simulate a simple dice game where the user inputs numbers
 * and the computer rolls dice to determine the winner.
 */
public class DiceGame {

    private static final int NUM_ROLLS = 3;
    private static final int MAX_DICE_VALUE = 6;

    public static void main(String[] args) {
        int userSum = getRandomNums();
        int diceSum = rollDice();
        System.out.println("Your sum: " + userSum);
        System.out.println("Dice sum: " + diceSum);
        if (userSum > diceSum && userSum - diceSum < 3) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose.");
        }
    }

    /**
     * Function name: getRandomNums
     * @return userSum (int)
     * Inside the function:
     * 1. Gets 3 numbers from the user and sums them.
     */
    public static int getRandomNums() {
        Scanner scanner = new Scanner(System.in);
        int userSum = 0;
        System.out.println("Enter number between 0 and 6.");
        for (int i = 0; i < NUM_ROLLS; i++) {
            System.out.print((i + 1) + ". number: ");

            int num = scanner.nextInt();
            if (num < 0 || num > 6){
                System.out.print("Number must be betweeen 0 and 6; Enter again: ");
                num = scanner.nextInt();
            }
            userSum += num;
        }

        scanner.close();

        return userSum;
    }

    /**
     * Function name: rollDice
     * @return diceSum (int)
     * Inside the function:
     * 1. Rolls dice 3 times and sums the numbers.
     */
    public static int rollDice() {
        Random rand = new Random();
        int diceSum = 0;

        for (int i = 1; i <= NUM_ROLLS; i++) {
            int randomNum = rand.nextInt(MAX_DICE_VALUE) + 1;
            System.out.println(i + ". dice roll = " + randomNum);
            diceSum += randomNum;
        }

        return diceSum;
    }
}
