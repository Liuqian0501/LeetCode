public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //implement a kmp algorithm, but we don't know which devider to use, in this case if the s.length() is even, the first half has to be equal to the second half. if s.length() is odd,
        if(s==null || s.length() <= 1) return false;
        int mid = (s.length() - 1)/2 + 1;
        return tryDivider(s, mid);
    }
    private boolean tryDivider(String s, int mid){
        boolean res;
        for(int i = mid ; i > 0; i--){
            res = true;
            if(s.length()%i != 0)
                continue;
            else{
                //check devider, return turn if one of them works
                for(int j = 0; j < (s.length()/i)-1; j++){
                    res = res && (s.substring( j*i, (j+1)*i ).equals(s.substring( (j+1)*i, (j+2)*i )));
                }
                if(res) return true;
            }
        }
        return false;
    }
}
