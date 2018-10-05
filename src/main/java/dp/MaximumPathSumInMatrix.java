package dp;


//Input : mat[][] = 10 10  2  0 20  4
//        1  0  0 30  2  5
//        0 10  4  0  2  0
//        1  0  2 20  0  4
//        Output : 74
//        The maximum sum path is 20-30-4-20.
//
//        Input : mat[][] = 1 2 3
                    //        9 8 7
                    //        4 5 6
//        Output : 17
//        The maximum sum path is 3-8-6.
public class MaximumPathSumInMatrix {

    int maxValue(int[][] input) {
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

}
