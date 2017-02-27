public class Solution {
    public int rob(int[] nums) {
            int head = 0, end = nums.length;
            if(end == 0) return 0;
            if(end == 1) return nums[0];

            int res1 = nonCircle(nums,  head,  end - 1);
            int res2 = nonCircle(nums,  head + 1, end);
            return res1 > res2 ? res1:res2;
    }
    public int nonCircle(int[] nums, int head, int end){
        if(end > 0){
            int len = end;
            int[] sum = new int[len + 1];
            sum[head] = 0;
            sum[head + 1] = nums[head];
            for(int i = head + 2; i < end + 1; i++){
                sum[i] = sum[i-1] > (sum[i-2] + nums[i-1]) ? sum[i-1] : (sum[i-2] + nums[i-1]) ;
            }
            return sum[len];
        }
        return 0;
    }
}
