import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 */

/**
 * @author LiuQianKevin
 *
 */
public class ContainsDuplicate {

	/**
	 * @param args
	 */
	/*
	 *  apply hashset
	 *  space O(n), time O(n)
	 */
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i: nums){
			if(!set.add(i)){
				return true;
			}
		}
		return false;
    }
	//apply hashtable *  space O(n), time O(n)
	public static boolean containsDuplicate2(int[] nums) {
		Map<Integer,Integer> hMap = new HashMap();
		for(int i: nums){
			if(!hMap.containsKey(i)){
				hMap.put(i, 1);
			}else {
				return true;
			}
		}
		return false;
    }
	
	//in place  space O(n^2)
	public static boolean containsDuplicate3(int[] nums) {
		for(int i = 0;i+1<nums.length;i++){
			for(int j = i+1; j<nums.length; j++){
				if(nums[i]==nums[j]){
					return true;
				}
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,1};
		System.out.println(containsDuplicate3(a));
	}

}
