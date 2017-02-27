public class Solution {
    public int rob(int[] nums) {
        if(nums.length > 0){
            int len = nums.length;
            int[] sum = new int[len + 1];
            sum[1] = nums[0];
            for(int i = 2; i < nums.length + 1; i++){
                sum[i] = sum[i-1] > (sum[i-2] + nums[i-1]) ? sum[i-1] : (sum[i-2] + nums[i-1]) ;
            }
            return sum[len];
        }
        return 0;
    }
}
