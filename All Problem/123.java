//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/#/description
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int k =2;
        int[] buy = new int[k+1];
    	for(int i= 1; i <= k;i++){
    		buy[i] = Integer.MIN_VALUE;
    	}
    	int[] sell = new int[k+1];
    	
    	for(int i: prices){
    		for(int j = 1; j <= k;j++){
    			buy[j] = buy[j] > (sell[j-1] - i) ? buy[j] : (sell[j-1] - i);
    			sell[j] = sell[j] > (buy[j] + i) ? sell[j] : (buy[j] + i);
    		}
    	}
    	
        return sell[k];
    }
}
