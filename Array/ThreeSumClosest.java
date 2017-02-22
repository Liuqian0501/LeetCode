
import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */

/**
 * @author LiuQianKevin
 *
 */
public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[2];
		int start, end ,sum;
		for(int i=0; i+2<nums.length; i++){
			start = i+1;end = nums.length-1;
			while(start<end){
				sum = nums[start]+nums[end]+nums[i];
				if(sum > target) end--;
				else if(sum < target) start++;
				else return target;
				if(Math.abs(sum - target) < Math.abs(res - target)){
					res = sum;
				}
			}
		}
		return res;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,4,8,16,32,64,128};
		System.out.println(threeSumClosest(num, 82));
	}

}
