import java.util.*;

/*
// This prints the same thing using only println and no methods

public class Main {
    
    public static void main(String[] args) {
        System.out.println(
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\n" + 
                "       \u2588       \u2588       \n" + 
                " X   X \u2588  OOO  \u2588       \n" + 
                "  X X  \u2588 O   O \u2588       \n" + 
                "   X   \u2588 O   O \u2588       \n" + 
                "  X X  \u2588 O   O \u2588       \n" + 
                " X   X \u2588  OOO  \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       \n" + 
                "       \u2588       \u2588       ");
    }
}
*/

public class Main {
    
    public static char[][] grid;
    
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

    public static void main(String[] args) {
        init();
        
        /**
         * Parameter for addX and addO:
         * @param square    square number of block to insert, numbered as follows
         * 1|2|3
         * -----
         * 4|5|6
         * -----
         * 7|8|9 
         */
        addX(4);
        addO(5);
        
        print();
    }
    
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
    }
    
    public static void addX(int square) {
        // Calculate the grid offset for the square number
        int offsetX = --square / 3;
        int offsetY = square % 3;
        // Replace the characters in the grid with the characters to create an X
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                grid[8*offsetX+i][8*offsetY+j] = X[i][j];
            }
        }
    }
    
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
    
    public static void print() {
        // Prints each row of the board
        for (char[] arr : grid) {
            System.out.println(new String(arr));
        }
    }
}
