import linkedListCycle.ReverseList;

/**
 * Rotate an array of n elements to the right by k steps.
 */

/**
 * @author LiuQianKevin
 *
 */
public class RotateArray {

	/**
	 * @param args
	 */
    public static void rotate(int[] nums, int k) {
    	k = k>nums.length ? k%nums.length: k;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums, k, nums.length-1); 
    }
	private static void reverse(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int head = i, tail = j, temp = 0;
		while(head < tail){
			temp = nums[head];
			nums[head++] = nums[tail];
			nums[tail--] = temp;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2};
		rotate(nums, 3);
		for(int i: nums){
			System.out.print(i +" ");
		}
		
	}

}
