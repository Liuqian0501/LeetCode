public class Solution {
    public int findPairs(int[] nums, int k) {
        // to solve the fix difference problem, we need to first sort the array and then use two pointers to go through the whole array and store the output
        //base case
        if(nums == null || nums.length < 2) return 0;
        //sort array
        Arrays.sort(nums);
        int len = nums.length;
        int pointer1 = 0, pointer2 = 1;
        int diff;
        int count = 0;
        while(pointer2 < len){
            diff = nums[pointer2] - nums[pointer1];
            if(diff < k) pointer2++; //if the difference is smaller than k, increase pointer2
            else if(diff > k) pointer1++; //if the difference is larger than k, increase pointer1
            else if(diff == k){
                count++;
                pointer1++;
                while(nums[pointer1] == nums[pointer1 - 1] && pointer1 < len - 1) pointer1++; // skip same element;
            }
            while(pointer1 >= pointer2) pointer2++;
        }
        return count;
    }
}
