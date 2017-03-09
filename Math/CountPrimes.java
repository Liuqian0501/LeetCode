public class Solution {
    public int countPrimes(int n) {
        //base case
        if(n < 3) return 0;
        //In order to count all primes else than n, we start by find out all non-primes smaller than n
        // before that we need to find sqrt(n)
        int count = 0;
        boolean[] record = new boolean[n];
        for(int i = 2; i*i < n; i++){
            for(int j = i; i*j < n; j++){
                if(!record[i*j]){
                    count++;
                    record[i*j] = true;
                }
            }
        }
        return n - count - 2;
    }
}
