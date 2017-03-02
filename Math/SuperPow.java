public class Solution {
    public int superPow(int a, int[] b) {
        int base = a,res = 1;
        for(int i = 0; i < b.length; i++){
            a = myPow( base, b[b.length - i -1]) % 1337; // a^b[current digit] % 1337
            res = (a*res) % 1337; // a^(b[current digit] + previous res) % 1337;
            base = myPow( base, 10) % 1337; // a^(10^current digit)
        }
        return res;
    }
    
    public int myPow(int a , int pow){
        a %= 1337;
        if(pow == 0) return 1;
        if(pow < 0){
            a = 1/a;
            pow *= -1;
        }
        return (pow%2 == 0) ? myPow(a*a, pow/2) : a*myPow(a*a, pow/2);
    }
}
