import java.util.Objects;

public class Board {
    private final String[][] board;


    public Board() {
        board = new String[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = String.valueOf(Symbol.E);
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        // Check if move is within bounds
        if (row < 0 || row >= board.length || col < 0 || col >= board.length) {
            return false;
        }

        // Check if the cell is empty
        return Objects.equals(board[row][col], Symbol.E.toString());
    }

    public boolean makeMove(int row, int col, Symbol symbol) {
        if (isValidMove(row, col)) {
            board[row][col] = symbol.toString();
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isWin(Symbol symbol) {
        // check row & col
        for (int i = 0; i < board.length; i++) {
            // check row & col
            if (board[0][i].equals(symbol.toString()) && board[1][i].equals(symbol.toString()) && board[2][i].equals(symbol.toString()))
            {
                return true;
            }
            if (board[i][0].equals(symbol.toString()) && board[i][1].equals(symbol.toString()) && board[i][2].equals(symbol.toString()))
            {
                return true;
            }

            // check diagonals
            // left to right
            if (board[0][0].equals(symbol.toString()) && board[1][1].equals(symbol.toString()) && board[2][2].equals(symbol.toString())) {
                return true;
            }
            // right to left
            if (board[0][2].equals(symbol.toString()) && board[1][1].equals(symbol.toString()) && board[2][0].equals(symbol.toString())) {
                return true;
            }
        }

        return false;
    }

    public boolean isDraw() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(Symbol.E.toString())) {
                    return false;
                }
            }
        }

        return true;
    }
}
