package games;

import java.util.Arrays;


// X always plays first
public class Tictactoe {
    public static boolean isValidState(int[][] board) {
        if(board == null) return false;

        int[] rowSum = new int[board.length]; // add 1 if X and add -1 if O
        int[] columnSum = new int[board[0].length]; // add 1 if X and add -1 if O
        int diag1Sum = 0;
        int diag2Sum = 0;
        int turns = 0; // if X plays first and X wins - turns should be 1, if 0 wins then turns should be 0
        boolean xWin = false;
        boolean oWin = false;

        int rowCount=board.length;
        int columnCount=board[0].length;
        for (int i = 0; i < rowCount; i ++) {
            for (int j = 0; j < columnCount; j++) {
                if(board[i][j] == 1) {
                    rowSum[i]++;
                    columnSum[j]++;
                    if(i==j) diag1Sum++;
                    if(i+j == rowCount - 1) diag2Sum++;
                    turns++;
                }else if (board[i][j] == 0) {
                    rowSum[i]--;
                    columnSum[j]--;
                    if(i+j == rowCount - 1) {
                        if(i==j) diag1Sum--;
                        if(i+j == rowCount - 1) diag2Sum--;
                    }
                    turns--;
                }
            }
        }

        if(Arrays.stream(rowSum).anyMatch(sum -> sum==rowCount)
                || Arrays.stream(columnSum).anyMatch(sum -> sum==columnCount)
                || diag1Sum == rowCount
                || diag2Sum == columnCount) {
            xWin = true;
        }

        if(Arrays.stream(rowSum).anyMatch(sum -> sum==(-1 * rowCount))
                || Arrays.stream(columnSum).anyMatch(sum -> sum==(-1 * columnCount))
                || diag1Sum == (-1 * rowCount)
                || diag2Sum == (-1 * columnCount)) {
            oWin = true;
        }

        if(xWin && turns == 1) {
            return true;
        } else {
            return oWin && turns == 0;
        }
    }

    public static void main(String[] args) {
        int[][] ticTacToe = new int[][]{
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 1, 5}};
        System.out.println(isValidState(ticTacToe));
    }
}
