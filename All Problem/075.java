//https://leetcode.com/problems/sort-colors/#/description
public class Solution {
    public void sortColors(int[] nums) {
        int r=0, w=0, b=0; // label the end of different colors;
        for(int num: nums){
            nums[b++] = 2;
            if(num < 2) nums[w++] = 1;
            if(num < 1) nums[r++] = 0;
        }
    }
}
