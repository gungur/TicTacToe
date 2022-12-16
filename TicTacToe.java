import java.util.*;

/**
 * The user can play a game of TicTacToe against a CPU.
 */
public class TicTacToe {

    // global data fields, player positions need to be stored somewhere
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    /**
     * Main method
     *
     * @param args
     */
    public static void main (String[] args) {
        // initializing the game board
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);

        // keeps looping until the game is over
        while (true) {
            Scanner scan = new Scanner(System.in);
            // player goes first
            System.out.println("Enter your placement (1-9)");
            int playerPos = scan.nextInt();
            // need to make sure selected position isn't already taken
            while (playerPositions.contains(playerPos)
                    || cpuPositions.contains(playerPos)) {
                System.out.println("Position taken! Enter a correct Position");
                playerPos = scan.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");

            String result = checkWinner();
            // if true, either win, loss, or tie
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            // same idea as player, but using a random generator for the cpu
            Random rand = new Random();
            // randomly selects from 1 to 9, inclusive
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos)
                    || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");

            // printing the updated game board
            printGameBoard(gameBoard);

            // same idea as last time
            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }

    /**
     * Prints the game board as it is at the current state of time.
     *
     * @param gameBoard the 2D array the game is being played on
     */
    public static void printGameBoard(char[][] gameBoard) {
        // nested for loop because 2D array
        for(char[] row : gameBoard) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    /**
     * Stores which positions have been taken by which players and updates the game board accordingly.
     *
     * @param gameBoard the 2D array the game is being played on
     * @param pos the position to place a piece on the board
     * @param user either the player or cpu
     */
    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';

        // updating either ArrayLists and the symbol depending on who is the user
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }

        // iterates through switch cases until match is found
        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    /**
     * Determines whether player wins, losses, or if it's a tie.
     *
     * @return the result of the game
     */
    public static String checkWinner() {

        // listing all winning combinations and adding them all to an ArrayList
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            // checks for a match between all the winning combinations and the player positions
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!";
                // checks for a match between all the winning combinations and the cpu positions
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins! Sorry :(";
            }
        }

        // it is a tie if no winning combinations and the board is full
        // need to have a separate for loop to avoid a bug
        for (List l : winning) {
            if (playerPositions.size() + cpuPositions.size() == 9) {
                return "TIE!";
            }
        }

        return "";
    }

}