public class Solution {
    public int numWays(int n, int k) {
        //TO slove this arrangement problem, we need to new what can we do at each step and the coresponding constrains.
        // two cases
        
        //base case
        if(n == 0) return 0;
        if(n == 1) return k;
        
        //init
        int preDiff = k*(k-1);
        int preSame = k;
        int curDiff = preDiff;
        int curSame = preSame;
        
        for(int i = 2; i < n; i++){
            //if cur is diff, and prev is diff : preDiff * (k-1)
            //if cur is diff, and prev is same : preSame * (k-1)
            curDiff = (preDiff + preSame) * (k-1);
            
            //if cur is same, prev has to be diff
            curSame = preDiff * 1;
            
            preDiff = curDiff;
            preSame = curSame;
        }

        return curDiff + curSame;
    }
}
