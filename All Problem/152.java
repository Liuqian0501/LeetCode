public class Solution {
    public int maxProduct(int[] nums) {
    	int len = nums.length;
        if(len == 0) return 0;
        //find the minsofar and maxsofar with i include, res = max(maxsofar,minsofar)
        int max = nums[0], min = nums[0], result = nums[0];
        for(int i = 1; i<len;i++) {
            //max*i || min*i || restart from nums
            int temp = max;
            max = Math.max(Math.max(max*nums[i],   min*nums[i]),  nums[i]);
            min = Math.min(Math.min(temp*nums[i],   min*nums[i]),  nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }
}
