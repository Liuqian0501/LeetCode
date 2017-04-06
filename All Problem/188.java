//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/#/description
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length,res = 0;
        if(len == 0) return 0;
        if(len/2 < k) {
            for (int i = 0; i+1< len; i++) {
    			if(prices[i+1] - prices[i] > 0) {
    				res += (prices[i+1] - prices[i]);
    			}
		    }
		    return res;
        }
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

