

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

/**
 * @author LiuQianKevin
 *
 */
public class RemoveElement {

	/**
	 * @param args
	 */
    public static int removeElement(int[] nums, int val) {
    	int pointer = 0;
    	for(int i : nums){
    		if (i == val) {
				continue;
			}else{
				nums[pointer++] = i;
			}
    	}
		return pointer;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,3};
		System.out.println(removeElement(nums,2));
	}

}
