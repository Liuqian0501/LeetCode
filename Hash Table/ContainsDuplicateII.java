/**
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
package hashTable;

import java.util.HashMap;

/**
 * @author LiuQianKevin
 *
 */
public class ContainsDuplicateII {

	/**
	 * @param args
	 */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer, Integer> hashMap = new HashMap<>();
    	for(int i = 0; i < nums.length ; i++){
    		if(hashMap.containsKey(nums[i])){
    			if (i-hashMap.get(nums[i])<=k) {
					return true;
				}
    		}
    		hashMap.put(nums[i], i);
    	}
		return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,5,1,9,8,4,5,6,7};
		System.out.println(containsNearbyDuplicate(nums, 3));
	}

}
