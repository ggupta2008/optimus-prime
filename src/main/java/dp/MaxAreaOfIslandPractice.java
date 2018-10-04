package dp;

public class MaxAreaOfIslandPractice {


    public static void main(String[] args) {
        int[][] islandInput = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}};
        MaxAreaOfIslandPractice maxAreaOfIslandPractice = new MaxAreaOfIslandPractice();
        int result = maxAreaOfIslandPractice.maxAreaOfIsland(islandInput);
        System.out.println(result);
    }

    private int maxAreaOfIsland(int[][] islandInput) {
        if (islandInput == null) return 0;
        int maxArea = 0;
        for (int rowNum = 0; rowNum < islandInput.length; rowNum++) {
            for (int columnNum = 0; columnNum < islandInput[0].length; columnNum++) {
                if (islandInput[rowNum][columnNum] == 1) {
                    int tempArea = area(islandInput, rowNum, columnNum);
                    maxArea = Math.max(maxArea, tempArea);
                }
            }
        }
        return maxArea;
    }

    private int area(int[][] islandInput, int rowNum, int columnNum) {
        if (rowNum < 0 || columnNum < 0 || rowNum >= islandInput.length || columnNum >= islandInput[0].length || islandInput[rowNum][columnNum] == 0) {
            return 0;
        } else {
            islandInput[rowNum][columnNum] = 0;
            return 1 + area(islandInput, rowNum - 1, columnNum) + area(islandInput, rowNum + 1, columnNum) + area(islandInput, rowNum, columnNum - 1) + area(islandInput, rowNum, columnNum + 1);
        }

    }

}
