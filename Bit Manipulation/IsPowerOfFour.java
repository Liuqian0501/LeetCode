public class Solution {
    public boolean isPowerOfFour(int num) {
        System.out.println((num-1)&num);
        return ((num-1)&num)==0 && (num-1)%3==0;
    }
}


