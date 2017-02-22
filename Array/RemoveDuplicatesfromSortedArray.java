
/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.
 */

/**
 * @author LiuQianKevin
 *
 */
public class RemoveDuplicatesfromSortedArray {

	/**
	 * @param args
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums  == null) {
			return 0;
		}
		int pointer = 1;
		for(int i = 1; i < nums.length; i++){
			if (nums[i] == nums[pointer-1]) {
				continue;
			}else {
				nums[pointer++] = nums[i];
			}
		}
		return pointer;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(nums));
	}

}
