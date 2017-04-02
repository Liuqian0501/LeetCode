https://leetcode.com/problems/beautiful-arrangement/#/description
public class Solution {
    //The basic idea is to check every value at each position, if index i can have value n, then remove n from the choice set and solve the subproblem using the same algothm. Complete choice property.
    // value%index == 0 || index%value == 0
    int res = 0;
    public int countArrangement(int N) {
        if(N==0) return 0;
        //define a choice set
        boolean[] choice = new boolean[N+1];
        //Starting from position 0
        helper(1,N+1,choice);
        return res;
    }
    private void helper(int head, int tail, boolean[] choice){
        if(head == tail) {
            res++;
            return;
        }
        for(int i = 1; i < tail ; i++){
            if(choice[i] || (head%i != 0 && i%head != 0)) continue;
            choice[i] = true;
            helper(head+1, tail, choice);
            choice[i] = false;
        }
    }
}
