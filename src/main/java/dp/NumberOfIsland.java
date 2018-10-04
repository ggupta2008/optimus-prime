package dp;

public class NumberOfIsland {

    private int numIslands(char[][] islandInput) {
        int numIslands = 0;
        if (islandInput == null || islandInput.length == 0) {
            return 0;
        }
        for (int i = 0; i < islandInput.length; i++) {
            for (int j = 0; j < islandInput[0].length; j++) {
                if (islandInput[i][j] == '1') {
                    numIslands++;
                    dfs(islandInput, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] islandInput, int rowNum, int columnNum) {
        if (rowNum < 0 | columnNum < 0 || rowNum > islandInput.length || columnNum > islandInput[0].length || islandInput[rowNum][columnNum] == '0') {
            return;
        }
        islandInput[rowNum][columnNum] = '0';
        dfs(islandInput, rowNum - 1, columnNum);
        dfs(islandInput, rowNum + 1, columnNum);
        dfs(islandInput, rowNum, columnNum - 1);
        dfs(islandInput, rowNum, columnNum + 1);
    }

    public static void main(String[] args) {
        char[][] islandInput = new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        int result = numberOfIsland.numIslands(islandInput);
        System.out.println(result);
    }
}
