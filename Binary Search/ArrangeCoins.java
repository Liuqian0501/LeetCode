public class Solution {
    public int arrangeCoins(int n) {
        if(n<=0){
            return 0;
        }
        long start = 1, end = (long) n;
        long mid = start + (end - start)/2;
        while(start <= end){
            mid = start + (end - start)/2;
            if(mid*mid*0.5 + mid*0.5 < (long) n){
                start = mid + 1;
            }else if(mid*mid*0.5 + mid*0.5 > (long) n){
                end = mid - 1;
            }else{
                return  (int) mid;
            }
            //cal = mid*mid/2 + mid/2;
        }
        return (int) start -1;
    }
}
