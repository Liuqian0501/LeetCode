/**
 * Given an array of integers, 
 * every element appears twice except for one. Find that single one.
 */
package hashTable;

import java.util.HashMap;

/**
 * @author LiuQianKevin
 *
 */
public class SingleNumber {

	/**
	 * @param args
	 */
    public static int singleNumber(int[] nums) {
        int result = 0, len = nums.length;
        for (int i = 0; i<len; i++)
        {
    		result ^=nums[i];
    		System.out.println(result);
        }
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,7,9,9};
		System.out.println(singleNumber(nums));
	}

}
