//https://leetcode.com/problems/heaters/#/description
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // compare sorted arrays.
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int heaterIndex = 0, max = 0;
        for(int i : houses){
            //faster
            while(heaterIndex < heaters.length-1 && (heaters[heaterIndex] + heaters[heaterIndex+1]) < 2*i){
                heaterIndex++;
            }
            max = Math.max(max, Math.abs(heaters[heaterIndex]-i));
        }
        return max;
    }
}
