public class Solution {
    public int hammingDistance(int x, int y) {
        int countDifferent = 0;
        while(x!=0 || y!=0){
            countDifferent = countDifferent + (x&1 ^ y&1);
            x = x >>> 1;
            y = y >>> 1;
        }
        return countDifferent;
    }
}
