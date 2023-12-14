public class Main {
    private static Queen[] queens = new Queen[8];

    public static void main(String[] args) {
        setQueensOnRows();
        setUpQueens(0);
    }

    //Checking if two queens are attacking each other
    public static Boolean isAttacking(Queen a, Queen b) {
        return a.row == b.row || a.col == b.col ||
                Math.abs(a.row - b.row) == Math.abs(a.col - b.col);
    }

    //Assigning one queen to each row
    public static void setQueensOnRows() {
        for (int i = 0; i < 8; i++) {
            queens[i] = new Queen();
            queens[i].row = i;
        }
    }

    //Checking if the position on board is safe
    public static boolean isSafe(Queen[] position) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (isAttacking(position[i], position[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    //Setting up one queen on each column and print all possibilities.
    public static int count = 1;
    public static void setUpQueens(int row) {
        for (int i = 0; i < 8; i++) {
            queens[row].col = i;
            if (row < 7) {
                setUpQueens(row + 1);
            } else {
                if (isSafe(queens)) {
                    System.out.println("Position number: " + count);
                    drawBoard(doBoard(queens));
                    count++;
                }
            }
        }
    }

    //Creating a board
    public static String[][] doBoard(Queen[] position) {
        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (position[j].col == i) {
                    board[i][j] = "Q";
                } else board[i][j] = " ";
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
}