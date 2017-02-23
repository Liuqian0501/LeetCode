/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

/**
 * @author LiuQianKevin
 *
 */
public class BestTimetoBuyandSellStockIV {

	/**
	 * @param args
	 */
	// k times operation for loop
    public static int maxProfit(int[] prices, int k) {
    	if(prices.length == 0) return 0;
    	if(prices.length/2 < k) return quickSolu(prices);
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
    
    // quick solution
	private static int quickSolu(int[] prices) {
		// TODO Auto-generated method stub
		int res = 0;
		for (int i = 0; i+1< prices.length; i++) {
			if(prices[i+1] - prices[i] > 0) {
				res += (prices[i+1] - prices[i]);
			}
		}
		return res;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(a,2));
	}

}
