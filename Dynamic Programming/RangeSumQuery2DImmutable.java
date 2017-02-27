public class NumMatrix {
    int[][] subSum;
    public NumMatrix(int[][] matrix) {
        
        if(matrix.length!=0 && matrix[0].length !=0 ){
            int ylen = matrix.length, xlen = matrix[0].length;
            subSum = new int[ylen][xlen];
            for(int i = 0; i < ylen; i++){
                subSum[i][0] = matrix[i][0];
                for(int j = 1; j < xlen ; j++){
                    subSum[i][j] = subSum[i][j-1] + matrix[i][j];
                }
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i = row1; i <= row2; i++){
            if(col1 == 0){
                res += subSum[i][col2];
            }else{
                res += (subSum[i][col2] - subSum[i][col1-1]);
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
