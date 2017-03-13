public class Solution {
    public int maxRotateFunction(int[] A) {
        //go through k = 0- n-1
        if(A == null || A.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int index = 0;
        for(int j = 0; j < A.length; j++){
            sum = 0;
            for(int i = 0; i < A.length;i++){
                index = ( i >= j ) ? (i - j) : (A.length - j + i);
                sum += A[index] * i;
            }
            max = (max > sum) ? max : sum;
        }
        return max;
    }
}


// solution 2
public class Solution {
    public int maxRotateFunction(int[] A) {
        //go through k = 0- n-1
        if(A == null || A.length == 0) return 0;
        int len = A.length;
        int candidate = 0;
        int sum = 0;
        for(int j = 0; j < len; j++){
            sum += A[j];
            candidate += j*A[j];
        }
        int max = candidate;
        for(int j = len - 1; j >= 0; j--){
            candidate = candidate + sum - A.length*A[j];
            max = (max > candidate) ? max : candidate;
        }
        return max;
    }
}
