public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        int row = findRow(matrix,target);
        return findCol(matrix,row,target);
    }
    public int findRow(int[][] matrix, int target){
        int head = 0, tail = matrix.length-1, mid, col = matrix[0].length - 1;
        while(head <= tail){
            mid = head + (tail - head)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][col] ) return mid;
            else if (matrix[mid][col] < target) head = mid+1;
            else tail = mid - 1;
        }
        return -1;
    }
    public boolean findCol(int[][] matrix, int row, int target){
        if(row == -1) return false;
        int head = 0, tail = matrix[0].length - 1,mid;
        while(head <= tail){
            mid = head + (tail - head)/2;
            if(matrix[row][mid] == target) return true;
            else if (matrix[row][mid] < target) head = mid+1;
            else tail = mid - 1;
        }
        return false;
    }
}


//solution two
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >=0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}
