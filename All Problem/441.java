https://leetcode.com/problems/arranging-coins/

//1+2+3+...+x <= n
// x(x+1)/2 <= n
public class Solution {
    public int arrangeCoins(int n) {
        if(n<=0){
            return 0;
        }
        long start = 1, end = (long) n;
        long mid = start + (end - start)/2;//通过令mid = start + (end - start)/2; 可以加快计算速度。
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
        //当执行完整个循环后，start-1 = end，且start对应的值比目标值大，end对应的值比目标值小。
        return (int) end;
    }
}
