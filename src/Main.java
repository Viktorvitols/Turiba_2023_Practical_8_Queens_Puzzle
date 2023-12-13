public class Main {
    public static void main(String[] args) {
        setQueensOnRows();
        setQueensOnBoard(0, newBoard(8, 8));
    }

    private static Queen[] queens = new Queen[8];

    //Creating a board
    public static String[][] newBoard(int rows, int cols) {
        String[][] board = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = " ";
            }
        }
        return board;
    }

    //Print out the board
    public static void drawBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //Assigning one queen to each row
    public static void setQueensOnRows() {
        for (int i = 0; i < 8; i++) {
            queens[i] = new Queen();
            queens[i].row = i;
        }
    }

    //Checking if two queens are attacking each other
    public static Boolean isAttacking(Queen a, Queen b) {
        return a.row == b.row || a.col == b.col ||
                Math.abs(a.row - b.row) == Math.abs(a.col - b.col);
    }

    //Checking if the square is safe
    public static boolean isSafe(Queen[] square) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (isAttacking(square[i], square[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String[][] setQueensOnBoard(int row, String[][] board) {
        for (int i = 0; i < 8; i++) {
            queens[row].col = i;
            if (row < 7) {
                setQueensOnBoard(row + 1, board);
            } else {
                if (isSafe(queens)) {
                    board[row][queens[row].col] = "Q";
                    drawBoard(board);
                }
            }
        }
        return board;
    }
}