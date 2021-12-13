package bingo;

public class Board {
    private final int[][] board;
    private final boolean[][] rightNumbers;
    private final int boardNumber;
    private int lastCall;

    public Board(int[][] board, int boardNumber){
        this.boardNumber = boardNumber;
        this.rightNumbers = new boolean[5][5];
        this.board = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                rightNumbers[i][j] = false;
            }
        }
    }

    public int getBoardNumber() {
        return boardNumber;
    }

    public void addCallNumber(int number){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == number) {
                    rightNumbers[i][j] = true;
                    lastCall = number;
                }
            }
        }
    }

    public int finalScore(){
        int sum = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!rightNumbers[i][j]) {
                    sum += board[i][j];
                }
            }
        }
        return sum * lastCall;
    }

    private boolean winRow() {
        boolean win = false;
        for (boolean[] row : rightNumbers) {
            if (row[0] && row[1] && row[2] && row[3] && row[4]) {
                win = true;
                break;
            }
        }
        return win;
    }

    private boolean winCol() {
        boolean win1 = false, win2 = false, win3 = false, win4 = false, win5 = false;

        for (int i = 0; i < rightNumbers.length; i++) {
            if (rightNumbers[0][i]) {
                win1 = true;
            }

            if (rightNumbers[1][i]) {
                win2 = true;
            }

            if (rightNumbers[2][i]) {
                win3 = true;
            }

            if (rightNumbers[3][i]) {
                win4 = true;
            }
            
            if (rightNumbers[4][i]) {
                win5 = true;
            }

            if (win1 && win2 && win3 && win4 && win5) return true;
            win1 = false;
            win2 = false;
            win3 = false;
            win4 = false;
            win5 = false;
        }
        return false;
    }

    private boolean winDiagonal() {
        return rightNumbers[0][0] && rightNumbers[1][1] && rightNumbers[2][2] && rightNumbers[3][3] && rightNumbers[4][4] ||
                rightNumbers[0][4] && rightNumbers[1][3] && rightNumbers[2][2] && rightNumbers[3][1] && rightNumbers[4][0];
    }

    public boolean win() {
        return winRow() || winCol();
    }

}
