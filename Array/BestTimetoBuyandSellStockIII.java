/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

/**
 * @author LiuQianKevin
 *
 */
public class BestTimetoBuyandSellStockIII {

	/**
	 * @param args
	 */
    public static int maxProfit(int[] prices) {
    	int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
    	for(int i: prices){
    		buy1 = buy1 > -i ?  buy1: -i;
    		sell1 = sell1> (buy1 + i) ? sell1 : (buy1 + i);
    		buy2 = buy2 > (sell1 - i)  ? buy2 : (sell1 - i);
    		sell2 = sell2 > (buy2 + i) ? sell2 : (buy2 + i);
    	}
    	
        return sell2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,3,2,1,4,5,6,7};
		System.out.println(maxProfit(a));
	}

}
