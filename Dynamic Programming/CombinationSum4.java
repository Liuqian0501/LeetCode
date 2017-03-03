public class Solution {
    public int combinationSum4(int[] nums, int target) {
       // kind like Fibonacci
       int[] res = new int[target+1];
       Arrays.sort(nums);
       for(int i = 1; i <= target; i++){
           for(int num : nums){
               if(i == num) 
                    res[i] ++;
               else if
                    (i < num) break;
               else 
                    res[i] += res[i-num];
           }
       }
       return res[target];
    }
}
