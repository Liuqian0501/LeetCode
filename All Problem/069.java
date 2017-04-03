//https://leetcode.com/problems/sqrtx/#/description
public class Solution {
    public int mySqrt(int x) {
        if(x > 0){
            long head = 0, tail = x, mid = head + (tail-head)/2;
            while(head <= tail){
                if(mid*mid < x) head = mid + 1;
                else if(mid*mid > x) tail = mid - 1;
                else return (int)mid;
                mid = head + (tail-head)/2;
            }
            return (int)tail;
            //当执行完整个循环后，start-1 = end，且start对应的值比目标值大，end对应的值比目标值小。
        }else{
            return x;
        }
    }
}
