public class Solution {
    public int minCostII(int[][] costs) {
        //base case
        if(costs == null || costs.length < 1 || costs[0].length < 1) return 0;
        int k = costs[0].length;
        
        //first step option
        int[] lastColor = new int[k];
        int[] curColor = new int[k];
        for(int i = 0; i < k; i++){
            lastColor[i] = costs[0][i];
            curColor[i] = costs[0][i];
        }
        
        //subset option
        for(int i = 1; i<costs.length; i++){
            curColor = findCurColor(lastColor, costs, i, k);
            lastColor = curColor;
        }
        
        //return the best res
        return findMin(curColor, k, k);
    }
    
    
   
    public int[] findCurColor(int[] lastColor,int[][] costs,int j, int k){
        // find the current color based on previous color
        int[] curColor = new int[k];
        for(int i = 0; i<k; i++){
            curColor[i] = findMin(lastColor,i,k) + costs[j][i];
        }
        return curColor;
    }
    public int findMin(int[] lastColor, int j, int k){
        // find the min value except self
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k ; i++){
            if(i == j) continue;
            else min = min < lastColor[i] ? min : lastColor[i];
        }
        return min;
    }
}
