public class Solution {
    public List<String> generateParenthesis(int n) {
        //We can solve this kind of position arranging problem by considering every possible option at each step. The challenge here is the constrain for each problem.
        //the constrain for adding a '(' is # of '(' has to be smaller than n,
        //constrain for adding a ')' is # of ')' has to be smaller than # of '(';
        List<String> list = new ArrayList<>();
        String s = "";
        if(n == 0) return null;
        arrange(list, 0, 0, n , s);
        return list;
    }
    private void arrange(List<String> list, int open, int close, int n, String s){
        if(s.length() == 2* n){
            list.add(s);
        }
        if(open < n){
            arrange(list, open + 1, close, n, s + '(');
        }
        if(close < open){
            arrange(list, open, close + 1, n, s + ')');
        }
    }
}
