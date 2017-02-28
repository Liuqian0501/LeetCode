// solution 1
public class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}


// solution 2
public class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n  == 2) return n;
        int sum1 = 1, sum2 = 2, temp;
        for(int i = 2; i < n ; i++){
            temp = sum2;
            sum2 = sum1 + sum2;
            sum1 = temp;
        }
        return sum2;
    }
}
