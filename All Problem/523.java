//https://leetcode.com/problems/continuous-subarray-sum/#/description
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return false;
        int[] M = new int[len];
        Map<Integer, Integer> hashMap = new HashMap<>();
        M[0] = nums[0];
        int temp = 0;
        if(k!=0){
            temp = M[0]%k;
            hashMap.put(temp, 0);
        }
        for(int i = 1; i<len;i++){
            M[i] = M[i-1] + nums[i];
            if(k!=0){
                temp = M[i]%k;
                if(temp == 0) return true;// M[i] % k = 0
                if(hashMap.containsKey(temp)){
                    if(i - hashMap.get(temp) > 1) return true;// M[j]%k = m and M[i]%k = m  and i - j > 1
                }else{
                    hashMap.put(temp, i);
                }
            }
            if(k==0 && M[i] == 0) return true; // M[i] = k = 0
        }
        return false;
    }
}
