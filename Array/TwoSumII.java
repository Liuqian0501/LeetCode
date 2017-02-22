package binarySearch;
/*
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.
@auther Qian Liu
 */
public class TwoSumII {
	// search index from head and tail
	public static int[] twoSum(int[] numbers, int target) {
   		// search index from head and tail
		int head = 0, tail = numbers.length-1;
		int[] res = {0,0};
		while(head < tail){
			if(numbers[head] + numbers[tail] < target){
				head ++;
			}else if( numbers[head] + numbers[tail] > target){
				tail --;
			}else{
				res[0] = head+1;
				res[1] = tail+1;
				return res;
			}
		}
		return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		System.out.println(twoSum(a, 3)[0]+" "+twoSum(a, 3)[1]);
	}

}
