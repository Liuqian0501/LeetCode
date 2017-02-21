/*
 * Given a sorted array and a target value, return the index if the target is found.
 *  If not, return the index where it would be if it were inserted in order.
 *  @auther Qian Liu
 */
public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		// base case
		int left = 0, right = nums.length-1, mid = 0;
		if (target > nums[right]) {
			return right+1;
		}
		if (target <= nums[left]) {
			return left;
		}
		
		// implemenet binary search
		//define mid point and compare target with mid point
		while(true){
			mid = (left + right)/2;
			if (nums[mid]<target) {
				left = mid;
			}else if(nums[mid] > target) {
				right = mid;
			}else{
				return mid;
			}
			if (right - left == 1) {
				return right;
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,7};
		System.out.println(searchInsert(nums, 1)) ;
	}

}
