/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

/**
 * @author LiuQianKevin
 *
 */
public class BestTimetoBuyandSellStockII {

	/**
	 * @param args
	 */
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int min = prices[0], totolprofit = 0, profit = 0;
    	for(int i:prices){
    		if(profit >= (i - min)){
    			totolprofit += profit;
    			profit = 0;
    			min = i;
    		}else{
    			profit = i - min;
    		}
    	}
    	totolprofit += profit;
        return totolprofit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,3,4,4,5,6,7,6,7};
		System.out.println(maxProfit(prices));
	}

}
