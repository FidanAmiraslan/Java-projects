import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String[] choices = new String[]{"rock", "paper", "scissors"};
        int index = rand.nextInt(choices.length); // getting random index for computer's choice
        String comp = choices[index];

        System.out.print("Enter your choice (rock, paper, scissors): "); // getting choice from user
        String user = scanner.nextLine().trim().toLowerCase();

        if (isValidChoice(user)) { // checking if input is valid
            printResults(user, comp);
        } else {
            System.out.println("Invalid entry; please enter rock, paper, or scissors.");
        }

        scanner.close();
    }

    /**
     * Function name: printResults
     * @param user - the user's choice
     * @param comp - the computer's choice
     * Inside the function:
     * 1. Prints the game results according to the output of isUserWinner function
     */
    public static void printResults(String user, String comp) { 
        System.out.println("You chose: " + user + ", Computer chose: " + comp);
        if (user.equals(comp)) {
            System.out.println("It is a tie.");
        } else if (isUserWinner(user, comp)) {
            System.out.println("You won!");
        } else {
            System.out.println("Computer won!");
        }
    }

    /**
     * Function name: isUserWinner
     * @param user - the user's choice
     * @param comp - the computer's choice
     * @return (boolean) - true if the user wins, false otherwise
     * Inside the function:
     * 1. Checks if the user is the winner according to rock-paper-scissors rules
     */
    public static boolean isUserWinner(String user, String comp) {
        return ((user.equals("rock") && comp.equals("scissors")) || 
                (user.equals("scissors") && comp.equals("paper")) || 
                (user.equals("paper") && comp.equals("rock")));
    }

    /**
     * Function name: isValidChoice
     * @param choice - the user's input choice
     * @return (boolean) - true if the choice is valid, false otherwise
     * Inside the function:
     * 1. Checks if the user entered the choice among rock-paper-scissors correctly
     */
    public static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }
}