package dp;

public class CoinChangeWays {
    public static int makeChange(int[] coins, int money, int index) { // index is for telling
                                                                    // which coin we are considering
                                                                    // for this iteration
        int amountWithCoin = 0;
        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;

            amountWithCoin+=coins[index];
        }
        return 0;
    }
}
