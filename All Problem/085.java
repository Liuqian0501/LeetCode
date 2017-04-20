public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        if(col == 0) return 0;
        
        int max = 0;
        int[] height = new int[col];
        for(int i = 0; i < row; i++){
            //generate histgram for all rows 
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1')
                    height[j] += 1;
                else
                    height[j] = 0;
            }
            max = Math.max( largestRectangleArea(height) , max);  
        }
        return max;
    }
    
    /**
     * Largest Rectangle in Histogram
     */
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
