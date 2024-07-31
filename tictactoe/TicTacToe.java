import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] table = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};
        printTable(table);
        String sign = "X";
        int moves = 0;
        
        while (true) {
            System.out.println("Enter your choice; You are " + sign);
            System.out.print("First enter row then column: ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            
            if (row < 0 || row > 2 || column < 0 || column > 2 || !table[row][column].equals("_")) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            
            table[row][column] = sign;
            moves++;
            printTable(table);
            
            if (checkWinner(table)) {
                System.out.println("Player " + sign + " wins!");
                break;
            }
            
            if (moves == 9) {
                System.out.println("It's a draw!");
                break;
            }
            
            sign = sign.equals("X") ? "O" : "X";
        }

        scanner.close();
    }
    
    public static void printTable(String[][] table) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkWinner(String[][] table) {
        // Check diagonals
        if (table[0][0].equals(table[1][1]) && table[1][1].equals(table[2][2]) && !table[0][0].equals("_")) {
            return true;
        }
        if (table[0][2].equals(table[1][1]) && table[1][1].equals(table[2][0]) && !table[0][2].equals("_")) {
            return true;
        }
        
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            // Check columns
            if (table[0][i].equals(table[1][i]) && table[1][i].equals(table[2][i]) && !table[0][i].equals("_")) {
                return true;
            }
            // Check rows
            if (table[i][0].equals(table[i][1]) && table[i][1].equals(table[i][2]) && !table[i][0].equals("_")) {
                return true;
            }
        }
        
        return false;
    }
}
