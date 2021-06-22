import java.util.Arrays;
public class Board {
    /**
     * This class is responsible for printing a board to STDOUT from a BoardState,
     * without debugging information and with a pretty grid.
     */
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
    
    /**
     * Do not allow a Board class to be instantiated
     */
    private Board() {}
    
    /**
     * Converts a BoardState into a character array
     * @param state The current board state
     */
    public static void print(BoardState state) {
        char[][] grid = new char[23][23];
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
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state.board[i][j] == 1) {
                    addO(i * 3 + j + 1, grid);
                } else if (state.board[i][j] == -1) {
                    addX(i * 3 + j + 1, grid);
                }
            }
        }
        
        print(grid);
    }
    
    /**
     * Prints the tic tac toe board to stdout
     */
    private static void print(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 77; i++) sb.append('\n');
        for (char[] arr : grid) {
            sb.append(arr);
            sb.append('\n');
        }
        System.out.print(sb);
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
    private static void addX(int square, char[][] grid) {
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
    private static void addO(int square, char[][] grid) {
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
}
