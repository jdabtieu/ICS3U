import java.util.Arrays;

public class BoardState implements Cloneable {
    /**
     * board        a 3x3 byte array representing the current board. 1 if filled by O, -1 if filled by X, 0 if empty
     * winner       who wins in the position, given optimal play. 1 if the current player wins, 0 if a tie is guaranteed, -1 if the other player wins
     * optimalMove  the optimal move in this position
     * turn         whose turn it is. 1 if it is O's turn, -1 if it is X's turn
     */
    public byte[][] board;
    public byte winner;
    public byte optimalMove;
    public byte turn;
    
    /**
     * Creates a brand new empty board
     */
    public BoardState() {
        this(new byte[3][3], (byte) -128, (byte) 0, (byte) 1);
    }
    
    /**
     * Creates a board using the given board position, winner, optimal move, and turn
     * @param board         The board
     * @param winner        The winner, given optimal play
     * @param optimalMove   The optimal move
     * @param turn          Whose turn it is
     */
    public BoardState(byte[][] board, byte winner, byte optimalMove, byte turn) {
        this.board = board;
        this.winner = winner;
        this.optimalMove = optimalMove;
        this.turn = turn;
    }
    
    /**
     * Creates a board using the given board position and turn, with unknown win information.
     * @param board     The board
     * @param turn      Whose turn it is
     */
    public BoardState(byte[][] board, byte turn) {
        this(board, (byte) -128, (byte) 0, turn);
    }
    
    /**
     * Checks if there is a win in this board
     * @return  1 if O wins, -1 if X wins, 0 if it is a tie, -2^31 if undetermined
     */
    public int win() {
        // Rows
        int check = board[0][0] + board[0][1] + board[0][2];
        if (check == 3) return 1;
        if (check == -3) return -1;
        check = board[1][0] + board[1][1] + board[1][2];
        if (check == 3) return 1;
        if (check == -3) return -1;
        check = board[2][0] + board[2][1] + board[2][2];
        if (check == 3) return 1;
        if (check == -3) return -1;
        
        // Columns
        check = board[0][0] + board[1][0] + board[2][0];
        if (check == 3) return 1;
        if (check == -3) return -1;
        check = board[0][1] + board[1][1] + board[2][1];
        if (check == 3) return 1;
        if (check == -3) return -1;
        check = board[0][2] + board[1][2] + board[2][2];
        if (check == 3) return 1;
        if (check == -3) return -1;
        
        // Diagonals
        check = board[0][0] + board[1][1] + board[2][2];
        if (check == 3) return 1;
        if (check == -3) return -1;
        check = board[0][2] + board[1][1] + board[2][0];
        if (check == 3) return 1;
        if (check == -3) return -1;
        
        // Tie
        check = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 0) check++;
            }
        }
        if (check == 9) return 0;
        
        return Integer.MIN_VALUE;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return this == null;
        if (!(obj instanceof BoardState)) return false;
        BoardState other = (BoardState) obj;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != other.board[i][j]) return false;
            }
        }
        return turn == other.turn;
    }

    @Override
    public int hashCode() {
        int res = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res = 2 * res + board[i][j];
            }
        }
        res = 2 * res + turn;
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.append(board[i][j]);
                res.append('|');
            }
            res.append(board[i][2]);
            res.append("\n-+-+-\n");
        }
        for (int j = 0; j < 2; j++) {
            res.append(board[2][j]);
            res.append('|');
        }
        res.append(board[2][2]);
        res.append("\nWinner: ");
        int tmp = winner * turn;
        if (tmp == 1) {
            res.append("O\n");
        } else if (tmp == 0) {
            res.append("Tie\n");
        } else if (tmp == -1) {
            res.append("X\n");
        } else {
            res.append("Unknown\n");
        }
        res.append("Best Move: ");
        if (optimalMove == 0) {
            res.append("Unknown\n");
        } else {
            res.append(optimalMove);
            res.append('\n');
        }
        res.append("Turn: ");
        if (turn == 1) {
            res.append("O");
        } else {
            res.append("X");
        }
        return res.toString();
    }
    
    @Override
    public BoardState clone() {
        byte[][] board = Arrays.stream(this.board).map(byte[]::clone).toArray(byte[][]::new);
        return new BoardState(board, winner, optimalMove, turn);
    }
}
