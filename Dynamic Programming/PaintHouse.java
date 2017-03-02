public class Solution {
    public int minCost(int[][] costs) {
        // At the first step, there are three options to choose from;
        if(costs == null || costs.length < 1 || costs[0].length < 1) return 0;
        int lastR = costs[0][0], lastB = costs[0][1], lastG = costs[0][2];
        int curR = lastR, curB = lastB, curG = lastG, curMin;
        //After the first step we are left with subset options with no extra constrain; list all of them!
        for(int i = 1; i< costs.length; i++){
            curR = lastB < lastG ? lastB + costs[i][0] : lastG + costs[i][0];
            curB = lastR < lastG ? lastR + costs[i][1] : lastG + costs[i][1];
            curG = lastR < lastB ? lastR + costs[i][2] : lastB + costs[i][2];
            lastR = curR;
            lastB = curB;
            lastG = curG;
        }
        // among all the posible options there is a best.
        curMin = curB < curG ? curB : curG;
        return curR < curMin ? curR : curMin;
    }
}
