public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int min = prices[0];
        int profit = 0, totalProfit = 0;
        for(int i : prices){
            if(profit > i - min){//sell the stock
                totalProfit += profit;
                profit = 0;
                min = i;
            }else{
                profit = i - min;//buy
            }
        }
        totalProfit += profit;
        return totalProfit;
    }
}
