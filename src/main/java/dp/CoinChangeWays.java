package dp;

public class CoinChangeWays {
     public int[] DENOMINATIONS = {1,2,5,10,20,50,100,500};


     public int combinations(int amount, int currentCoin) {
         if(amount==0) return 1;
         if(amount<0) return 0;
         int nCombinations = 0;
         for (int i = currentCoin; i < DENOMINATIONS.length; i++) {
             nCombinations+=combinations(amount-DENOMINATIONS[i], i);
         }
         return nCombinations;
     }


    public static void main(String[] args) {
        CoinChangeWays coinChangeWays = new CoinChangeWays();
        System.out.println(coinChangeWays.combinations(484,0));
    }
}
