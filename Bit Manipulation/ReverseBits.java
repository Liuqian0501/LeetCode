public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = n&1;
        n >>>= 1;
        for(int i = 1; i < 32; i++){
            res = res *2;
            res += n&1;
            n >>>= 1;
        }
        return res;
    }
}

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = n&1;
        n = n >>> 1;
        for(int i = 1; i < 32; i++){
            res = res *2;
            res += n&1;
            n = n >>>1;
        }
        return res;
    }
}
