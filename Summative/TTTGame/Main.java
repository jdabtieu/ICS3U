import java.util.*;
import java.io.*;

public class Main {
    static Scanner in = new Scanner(System.in);

    static Map<BoardState, BoardState> states = new HashMap<BoardState, BoardState>();
    
    public static void main(String[] args) {
        System.out.print("Loading...");
        // Compute all possible states
        dfs(new BoardState());
        System.out.println("Done!");
        banner();

        do {
            play();
            System.out.println("Play again? [Y/n]");
        } while (in.nextLine().toLowerCase().equals("y"));
    }

    public static void play() {
        // Create a new board and print it
        BoardState board = new BoardState();
        Board.print(states.get(board));
        
        // Keep running until someone wins or it results in a tie
        while (board.win() == Integer.MIN_VALUE) {
            // Get user move and compute row and column
            int move;
            int row;
            int col;
            do {
                move = readInt();
                row = --move / 3;
                col = move % 3;
            } while (board.board[row][col] != 0);
            
            // Make user move
            board.board[row][col] = 1;
            board.turn = (byte) -board.turn;
            
            // Get optimal computer move
            BoardState optimal = states.get(board);
            move = optimal.optimalMove;
            
            // Check if the game is over
            if (move == 0) {
                Board.print(optimal);
                break;
            }
            
            // Compute row and column
            row = --move / 3;
            col = move % 3;
            
            // Make computer move
            board.board[row][col] = -1;
            board.turn = (byte) -board.turn;
            Board.print(states.get(board));
        }
        int winner = board.win();
        switch(winner) {
        case 1:
            System.out.println("Congratulations! You won!");
            System.out.println("Also stop cheating because you can't win tic tac toe");
            break;
        case 0:
            System.out.println("Yay! It's a tie!");
            break;
        case -1:
            System.out.println("You were defeated by the computer. Try again next time.");
        }
    }
    
    public static void dfs(BoardState state) {
        // Check if the current board state is done
        int winner = state.win();
        if (winner != Integer.MIN_VALUE) {
            state.winner = (byte) (winner * state.turn);
            states.put(state, state);
            return;
        }
        
        byte currPlayer = state.turn;
        int bestOutcome = 2;
        int bestMove = -1;
        // For each empty square:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state.board[i][j] == 0) {
                    // Fill it in and recurse again
                    BoardState copy = state.clone();
                    copy.board[i][j] = currPlayer;
                    copy.turn = (byte) -state.turn;
                    if (!states.containsKey(copy)) {
                        dfs(copy);
                    }
                    
                    // Determine the optimal move
                    copy = states.get(copy);
                    if (copy.winner < bestOutcome) {
                        bestOutcome = copy.winner;
                        bestMove = 3 * i + j + 1;
                    }
                }
            }
        }
        // Fill in the current state's optimal move and winner
        state.optimalMove = (byte) bestMove;
        state.winner = (byte) -bestOutcome;
        states.put(state, state);
        return;
    }

    static int readInt() {
        int n;
        do {
            System.out.print(">>> ");
            while (!in.hasNextInt()) {
                System.out.print(">>> ");
                in.next();
            }
            n = in.nextInt();
        } while (n > 9 || n < 1);
        in.nextLine(); // Remove garbage
        return n;
    }

    static void banner() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 77; i++) sb.append('\n');
        sb.append(
            "===============================================\n" +
            "|  _______ _   _______      _______           |\n" +
            "| |__   __(_) |__   __|    |__   __|          |\n" +
            "|    | |   _  ___| | ____  ___| | ___   ___   |\n" +
            "|    | |  | |/ __| |/ _  |/ __| |/ _ \\ / _ \\  |\n" +
            "|    | |  | | (__| | (_| | (__| | (_) |  __/  |\n" +
            "|    |_|  |_|\\___|_|\\__,_|\\___|_|\\___/ \\___|  |\n" +
            "|                                             |\n" +
            "===============================================\n" +
            "By Jonathan Wu, ICS3U1-G1 2020-2021"
        );
        System.out.print(sb);
        System.out.println("\nPress Enter to begin");
        in.nextLine();
    }
}

