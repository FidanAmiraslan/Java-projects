import java.util.Random;

public class Pokerito {
    private static final int CARD_MIN = 1;
    private static final int CARD_MAX = 13;
    private static final int RIVER_SIZE = 5;
    private static final Random rand = new Random();
    public static void main(String[] args) {
        int userMatch = 0, compMatch = 0;
        int userCardIndex = drawCard();
        int compCardIndex = drawCard();

        System.out.println("Your card:");
        printCard(userCardIndex);

        System.out.println("Computer's card:");
        printCard(compCardIndex);

        System.out.println("RIVER STARTED!!!");
        for (int i = 0; i < RIVER_SIZE; i++) {
            int riverCard = drawCard();
            userMatch += (riverCard == userCardIndex) ? 1 : 0;
            compMatch += (riverCard == compCardIndex) ? 1 : 0;
            printCard(riverCard);
        }

        printResults(userMatch, compMatch);
    }

    /**
     * @return (int)
     * Inside the function:
     * 1. Draws a card index from 1 to 13;
     */
    public static int drawCard() {
        return rand.nextInt(CARD_MIN, CARD_MAX + 1);
    }

    /**
     * 
     * @param userMatch
     * @param compMatch
     * @return (boolean)
     * Inside the function:
     * 1. If the user match number is bigger than computer match returns true, otherwise returns false;
     */
    public static boolean isUserWinner(int userMatch, int compMatch) {
        return userMatch > compMatch;
    }

    /**
     * Inside the function:
     * Prints the card representation based on the card index.
     *
     * @param index
     */
    public static void printCard(int index) {
        String card = switch (index) {
            case 1 -> """
                   _____
                  |A _  |
                  | ( ) |
                  |(_'_)|
                  |  |  |
                  |____V|
                """;
            case 2 -> """
                   _____
                  |2    |
                  |  o  |
                  |     |
                  |  o  |
                  |____Z|
                """;
            case 3 -> """
                   _____
                  |3    |
                  | o o |
                  |     |
                  |  o  |
                  |____E|
                """;
            case 4 -> """
                   _____
                  |4    |
                  | o o |
                  |     |
                  | o o |
                  |____h|
                """;
            case 5 -> """
                   _____
                  |5    |
                  | o o |
                  |  o  |
                  | o o |
                  |____S|
                """;
            case 6 -> """
                   _____
                  |6    |
                  | o o |
                  | o o |
                  | o o |
                  |____6|
                """;
            case 7 -> """
                   _____
                  |7    |
                  | o o |
                  |o o o|
                  | o o |
                  |____7|
                """;
            case 8 -> """
                   _____
                  |8    |
                  |o o o|
                  | o o |
                  |o o o|
                  |____8|
                """;
            case 9 -> """
                   _____
                  |9    |
                  |o o o|
                  |o o o|
                  |o o o|
                  |____9|
                """;
            case 10 -> """
                   _____
                  |10  o|
                  |o o o|
                  |o o o|
                  |o o o|
                  |___10|
                """;
            case 11 -> """
                   _____
                  |J  ww|
                  | o {)|
                  |o o% |
                  | | % |
                  |__%%[|
                """;
            case 12 -> """
                   _____
                  |Q  ww|
                  | o {(|
                  |o o%%|
                  | |%%%|
                  |_%%%O|
                """;
            case 13 -> """
                   _____
                  |K  WW|
                  | o {)|
                  |o o%%|
                  | |%%%|
                  |_%%%>|
                """;
            default -> "";
        };
        System.out.println(card);
    }

    /**
     * Prints the results of the match;
     *
     * @param userMatch 
     * @param compMatch
     */
    public static void printResults(int userMatch, int compMatch) {
        System.out.println("Your match: " + userMatch);
        System.out.println("Computer's match: " + compMatch);

        if (userMatch == compMatch) {
            System.out.println("The match was a draw.");
        } 
        else if (isUserWinner(userMatch, compMatch)) {
            System.out.println("You won!");
        } 
        else {
            System.out.println("Computer won!");
        }
    }
}
