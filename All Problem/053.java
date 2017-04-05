//https://leetcode.com/problems/maximum-subarray/#/description
public class Solution {
    public int maxSubArray(int[] A) {
    	int res = A[0] , sum = 0;
    	for(int i : A){
    		sum+= i;
    		res = sum > res ? sum : res; // record the largest number
    		sum = sum > 0 ? sum : 0;
    	}
    	return res;
    }
}
