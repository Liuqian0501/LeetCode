import java.util.Arrays;

/*
 * @authur Qian Liu
 */

public class MajorityElement {
	public static int majorityElement(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length/2];
	    }
	public static void main(String args[]) {
		int[] str = {1,1,1,1,1,2,3,4,5};
    	long startTime = System.nanoTime();
    	int a = majorityElement(str);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime)/1000000 + " ms"); 
    	System.out.println(a);
	}
}
