import KNU.UTIL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String TAG = Main.class.getName();

    public static double buyAndSellStockTwice(List<Double> prices) {

        UTIL.LOG(3,TAG,"Input List : " + prices.toString());

        double maxTotalProfit = 0.0;
        List<Double> firstBuySellProfits = new ArrayList<>();
        double minPriceSoFar = Double.MAX_VALUE;

        // Forward phase. For each day, we record maximum profit if we
        // sell on that day.
        //*        UTIL.LOG(3,TAG,"Forward phase");
        for (int i = 0; i < prices.size(); ++i) {
            minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, prices.get(i) - minPriceSoFar);
            firstBuySellProfits.add(maxTotalProfit);
            UTIL.LOG(3,TAG,String.format(
                    "minPriceSoFar : %4.0f, maxTotalProfit : %4.0f, firstBuySellProfits: %s",
                    minPriceSoFar, maxTotalProfit, firstBuySellProfits.toString()
            ));

        }
//*/
         // Backward phase. For each day, find the maximum profit if we make
        // the second buy on that day.
        UTIL.LOG(3,TAG,"Backward phase");
        double maxPriceSoFar = Double.MIN_VALUE;
        double M = Double.MIN_VALUE;
        for (int i = prices.size() - 1; i > 0; --i){
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            M = Math.max(M, maxPriceSoFar - prices.get(i));
            maxTotalProfit
                    = Math.max(
                        maxTotalProfit,
                        maxPriceSoFar - prices.get(i) + firstBuySellProfits.get(i - 1)
                    );

            UTIL.LOG(3,TAG,String.format(
                    "M: %4.0f, maxPriceSoFar : %4.0f, maxTotalProfit : %4.0f, firstBuySellProfits(%d): %4.0f",
                    M, minPriceSoFar, maxTotalProfit, i-1, firstBuySellProfits.get(i - 1)
            ));

        }
        return maxTotalProfit;
    }

    public static void main(String[] args) {
        List<Double> test_DATA = Arrays.asList(
                12.0,11.0,13.0,9.0,12.0,8.0,14.0,13.0,15.0
        );
        double result = buyAndSellStockTwice(test_DATA);

        UTIL.LOG(3, TAG, "The Answer is : " + result);
    }
}