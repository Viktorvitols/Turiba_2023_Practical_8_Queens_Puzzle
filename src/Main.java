public class Main {
    static String[][] board;
    static int queensOnBoard = 0;

    public static void main(String[] args) {
        createBoard();
        while (queensOnBoard < 8) {
            solve();
            drawBoard();
        }

    }

    public static void solve() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (canSet(i, j)) {
                    setQueen(i, j);
                }
            }
        }
    }

    public static void createBoard() {
        board = new String[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    public static void drawBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void setQueen(int row, int col) {

        //fill col
        for (int i = 0; i < board.length; i++) {
            board[i][col] = ".";
        }
        //fill row
        for (int i = 0; i < board.length; i++) {
            board[row][i] = ".";
        }
        //fill diagonals
        int dRow1 = row;
        int dCol1 = col;
        int dRow2 = row;
        int dCol2 = col;
        int dRow3 = row;
        int dCol3 = col;
        int dRow4 = row;
        int dCol4 = col;
        while (dRow1 < 7 && dCol1 < 7) {
            board[++dRow1][++dCol1] = ".";
        }
        while (dRow2 > 0 && dCol2 > 0) {
            board[--dRow2][--dCol2] = ".";
        }
        while (dRow3 > 0 && dCol3 < 7) {
            board[--dRow3][++dCol3] = ".";

        }
        while (dRow4 < 7 && dCol4 > 0) {
            board[++dRow4][--dCol4] = ".";
        }

        board[row][col] = "Q";
        queensOnBoard++;
    }

    public static Boolean canSet(int row, int col) {
        if ((board[row][col]).equals("Q") | (board[row][col]).equals(".")) {
            return false;
        }
        return true;
    }
}