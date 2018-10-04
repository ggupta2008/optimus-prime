package dp;//Input: [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Not 7-1 = 6, as selling price needs to be larger than buying price.

public class StockSell {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int sofarMin = prices[0];
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] > sofarMin) {
                max = Math.max(max, prices[i] - sofarMin);
            } else {
                sofarMin = prices[i];
            }
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        StockSell stockSell = new StockSell();
        stockSell.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
