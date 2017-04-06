//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int profit = 0;
        int min = prices[0];
        for(int i : prices){
            profit = (profit > (i - min))? profit: i-min;
            min = (min < i)? min : i;
        }
        return profit;
    }
}
