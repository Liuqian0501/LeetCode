/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:


 */

/**
 * @author LiuQianKevin
 *
 */
public class BestTimetoBuyandSellStockwithCooldown {

	/**
	 * @param args
	 */
    public static int maxProfit(int[] prices) {
    	int profit = 0, len = prices.length;
    	if(len == 0){
    		return 0;
    	}
    	int[][] state = new int[4][len+1];
    	for(int i = 0; i< len+1 ; i++){
    		state[1][i] = Integer.MIN_VALUE;
    	}
    	for(int i = 1; i< len+1 ; i++){
    		state[1][i] = state[1][i-1] > (state[3][i-1] - prices[i-1]) ? state[1][i-1] : (state[3][i-1] - prices[i-1]);
    		state[2][i] = state[2][i-1] > (state[1][i-1] + prices[i-1]) ? state[2][i-1] : (state[1][i-1] + prices[i-1]);
    		state[3][i] = Math.max(Math.max(state[1][i-1], state[2][i-1]),state[3][i]);
    		//System.out.println(state[1][i]+"" +state[2][i]+"" + state[3][i]);
    	}
        return Math.max(Math.max(state[1][len], state[2][len]),state[3][len]);
    }
    
    public static int maxProfit2(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = (prev_sell - price) > prev_buy ? (prev_sell - price): prev_buy;
            prev_sell = sell;
            sell = (prev_buy + price) > prev_sell? (prev_buy + price) : prev_sell;
        }
        return sell;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {1,2,4};
		System.out.println(maxProfit(price));
	}

}
