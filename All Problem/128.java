//https://leetcode.com/problems/longest-consecutive-sequence/#/description
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
    
        Set<Integer> set = new HashSet<Integer>();
        
        for(int num: nums) set.add(num);
        int max = 1;
        for(int num: nums) {
            if(set.remove(num)) {//num hasn't been visited
                int sum = 1;
                int n = 1;
                while(set.remove(num-n)) n++;
                while(set.remove(num+sum)) sum++;
                sum += n-1;
                
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
