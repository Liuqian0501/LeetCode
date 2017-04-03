//https://leetcode.com/problems/search-insert-position/#/description
public class Solution {
    public int searchInsert(int[] nums, int target) {
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
}
