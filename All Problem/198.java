//https://leetcode.com/problems/house-robber/#/description
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        
        int[] sum = new int[len];
        sum[0] = nums[0];
        sum[1] = sum[0] > nums[1] ? sum[0]:nums[1]; 
        for(int i = 2;i<len;i++){
            sum[i] = (sum[i-1] > sum[i-2]+nums[i])? sum[i-1] : sum[i-2]+nums[i] ;//write the relation first, then work on i
        }
        return sum[len-1];
    }
}
