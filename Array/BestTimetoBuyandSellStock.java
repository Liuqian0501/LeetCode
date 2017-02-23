/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
 */

/**
 * @author LiuQianKevin
 *
 */
public class BestTimetoBuyandSellStock {

	/**
	 * @param args
	 */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0)  return 0;
        int profit = 0, min = prices[0]; 
    	for(int i : prices){
    		profit = profit > (i - min) ? profit : (i- min);
    		min = i < min ? i : min;
    	}
        return profit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,3,4};
		System.out.println(maxProfit(prices));
	}

}
