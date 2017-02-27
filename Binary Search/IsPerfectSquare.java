public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0){
            return false;
        }
        long head = 0, tail = num;
        long mid = head + (tail - head)/2, midsqr = mid*mid;
        while(head <= tail){
            if(midsqr < num){
                head = mid + 1;
            }else if(midsqr > num){
                tail = mid - 1;
            }else{
                return true;
            }
            mid = head + (tail - head)/2;
            midsqr = mid*mid;
        }
        return false;
    }
}
