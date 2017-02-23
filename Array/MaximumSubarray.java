/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 */

/**
 * @author LiuQianKevin
 *
 */
public class MaximumSubarray {

	/**
	 * @param args
	 */
	
    public static int maxSubArray(int[] A) {
    	int res = A[0] , sum = 0;
    	for(int i : A){
    		sum+= i;
    		res = sum > res ? sum : res;
    		sum = sum > 0 ? sum : 0;
    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3};
		System.out.println(maxSubArray(A));
	}

}
