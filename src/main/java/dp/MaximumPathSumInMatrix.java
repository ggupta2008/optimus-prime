package dp;



//        Input : mat[][] = 1 2 3
                    //        9 8 7
                    //        4 5 6
//        Output : 31
//        The maximum sum path is 1-9-8-7-6. The constraint is you can only move down and right
public class MaximumPathSumInMatrix {

    static int maxValue(int[][] input) {
        int r = input.length;
        int c = input[0].length;
        int[][] maxValues = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    maxValues[i][j] = input[i][j];
                } else if (i == 0) {
                    maxValues[i][j] = maxValues[i][j-1] + input[i][j];
                } else if (j == 0) {
                    maxValues[i][j] = maxValues[i-1][j] + input[i][j];
                } else {
                    maxValues[i][j] = Math.max(maxValues[i][j-1], maxValues[i-1][j]) + input[i][j];
                }
            }
        }
        return maxValues[r-1][c-1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3},{9,8,7},{4,5,6}};
        System.out.println(maxValue(input));
    }

}
