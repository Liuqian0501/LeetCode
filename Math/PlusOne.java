/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 */
package math;

/**
 * @author LiuQianKevin
 *
 */
public class PlusOne {

	/**
	 * @param args
	 */
	public static int[] plusOne(int[] digits) {
		int length = digits.length-1;
		while(length >=0){
			if(digits[length] < 9){
				digits[length]++;
				
				return digits;
			}
			digits[length--] = 0;
		}
		int[] res = new int[digits.length+1];
		res[0] = 1;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,9,9,9};
		nums = plusOne(nums);
		for(int i=0;i< nums.length; i++){
			System.out.print(nums[i]);
		}
	}

}
