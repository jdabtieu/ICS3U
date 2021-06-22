import java.util.*;

public class Main {
    
    public static char[][] grid;
    public static int p1wins = 0, p2wins = 0, ties = 0;
    
    public static final char[][] X = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', 'X', ' '},
            {' ', ' ', 'X', ' ', 'X', ' ', ' '},
            {' ', ' ', ' ', 'X', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', 'X', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', 'X', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
    };
    
    public static final char[][] O = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'O', 'O', 'O', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', 'O', ' '},
            {' ', 'O', ' ', ' ', ' ', 'O', ' '},
            {' ', 'O', ' ', ' ', ' ', 'O', ' '},
            {' ', ' ', 'O', 'O', 'O', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
    };

    public static void main(String[] args) throws InterruptedException {
        for (int cases = 0; cases < 10; cases++) {
            // Create a new board
            init();
            
            // Keep track of empty squares
            ArrayList<Integer> emptySquares = new ArrayList();
            for (int i = 1; i <= 9; i++) emptySquares.add(i);
            
            // Make moves
            for (int i = 0; i < 9; i++) {
                // Get a random (unoccupied) square number and add an X or O at that square
                int index = (int) (Math.random() * emptySquares.size());
                int square = emptySquares.get(index);
                if (i % 2 == 0) {
                    addO(square);
                } else {
                    addX(square);
                }
                emptySquares.remove(index);
                
                // Pause and redraw board
                Thread.sleep(800);
                print();
                
                // Check if a player has won or if it's a tie
                if (checkWin()) break;
                if (i == 8) {
                    ties++;
                    System.out.println("It's a tie!");
                }
            }
        }

        System.out.println("Player 1 wins: " + p1wins);
        System.out.println("Player 2 wins: " + p2wins);
        System.out.println("Ties: " + ties);
    }
    
    /**
     * Initializes the grid wite an empty tic tac toe board
     */
    public static void init() {
        // Initializes the grid and fills it with space characters
        grid = new char[23][23];
        for (char[] arr : grid) {
            Arrays.fill(arr, ' ');
        }
        
        // Creates the two horizontal and vertical lines with solid blocks
        for (int i = 0; i < 23; i++) {
            grid[7][i] = '\u2588';
            grid[i][7] = '\u2588';
            grid[15][i] = '\u2588';
            grid[i][15] = '\u2588';
        }
        
        // Add numbers
        grid[3][3] = '1';
        grid[3][11] = '2';
        grid[3][19] = '3';
        grid[11][3] = '4';
        grid[11][11] = '5';
        grid[11][19] = '6';
        grid[19][3] = '7';
        grid[19][11] = '8';
        grid[19][19] = '9';
    }
    
    /**
     * Adds an X at the specified square
     * 1|2|3
     * -----
     * 4|5|6
     * -----
     * 7|8|9 
     * @param square    the square number to target
     */
    public static void addX(int square) {
        // Calculate the grid offset for the square number
        int offsetX = --square / 3;
        int offsetY = square % 3;
        // Replace the characters in the grid with the characters to create an O
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                grid[8*offsetX+i][8*offsetY+j] = X[i][j];
            }
        }
    }
    
    /**
     * Adds an O at the specified square
     * 1|2|3
     * -----
     * 4|5|6
     * -----
     * 7|8|9 
     * @param square    the square number to target
     */
    public static void addO(int square) {
        // Calculate the grid offset for the square number
        int offsetX = --square / 3;
        int offsetY = square % 3;
        // Replace the characters in the grid with the characters to create an O
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                grid[8*offsetX+i][8*offsetY+j] = O[i][j];
            }
        }
    }
    
    /**
     * Prints the tic tac toe board to stdout
     */
    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 77; i++) sb.append('\n');
        for (char[] arr : grid) {
            sb.append(arr);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    
    /**
     * Checks if a player has won
     * @return  whether a player wins
     */
    public static boolean checkWin() {
        // Check X rows
        if ((grid[1][1] == grid[1][9] && grid[1][9] == grid[1][17] && grid[1][1] == 'X') ||
                (grid[9][1] == grid[9][9] && grid[9][9] == grid[9][17] && grid[9][1] == 'X') ||
                (grid[17][1] == grid[17][9] && grid[17][9] == grid[17][17] && grid[17][1] == 'X')) {
            System.out.println("Player 2 wins!");
            p2wins++;
            return true;
        }
        // Check X cols
        if ((grid[1][1] == grid[9][1] && grid[9][1] == grid[17][1] && grid[1][1] == 'X') ||
                (grid[1][9] == grid[9][9] && grid[9][9] == grid[17][9] && grid[1][9] == 'X') ||
                (grid[1][17] == grid[9][17] && grid[9][17] == grid[17][17] && grid[1][17] == 'X')) {
            System.out.println("Player 2 wins!");
            p2wins++;
            return true;
        }
        // Check X diagonals
        if ((grid[1][1] == grid[9][9] && grid[9][9] == grid[17][17] && grid[1][1] == 'X') ||
                (grid[1][17] == grid[9][9] && grid[9][9] == grid[17][1] && grid[1][17] == 'X')) {
            System.out.println("Player 2 wins!");
            p2wins++;
            return true;
        }
        // Check O rows
        if ((grid[1][2] == grid[1][10] && grid[1][10] == grid[1][18] && grid[1][2] == 'O') ||
                (grid[9][2] == grid[9][10] && grid[9][10] == grid[9][18] && grid[9][2] == 'O') ||
                (grid[17][2] == grid[17][10] && grid[17][10] == grid[17][18] && grid[17][2] == 'O')) {
            System.out.println("Player 1 wins!");
            p1wins++;
            return true;
        }
        // Check O cols
        if ((grid[1][2] == grid[9][2] && grid[9][2] == grid[17][2] && grid[1][2] == 'O') ||
                (grid[1][10] == grid[9][10] && grid[9][10] == grid[17][10] && grid[1][10] == 'O') ||
                (grid[1][18] == grid[9][18] && grid[9][18] == grid[17][18] && grid[1][18] == 'O')) {
            System.out.println("Player 1 wins!");
            p1wins++;
            return true;
        }
        // Check O diagonals
        if ((grid[1][2] == grid[9][10] && grid[9][10] == grid[17][18] && grid[1][2] == 'O') ||
                (grid[1][18] == grid[9][10] && grid[9][10] == grid[17][2] && grid[1][18] == 'O')) {
            System.out.println("Player 1 wins!");
            p1wins++;
            return true;
        }
        return false;
    }
}
