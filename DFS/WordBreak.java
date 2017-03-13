public class Solution {
    boolean res;
    String str;
    public boolean wordBreak(String s, List<String> wordDict) {
        //I am going to solve this problem using BFS
        //base case no s, no wordDict, s.length = 0
        //Case 1: no sub word in dictionary;
        //Case 2: one of them in dictionary; resursively call breakHelper(start, wordDict) for all word in wordDictionary
        
        // if new string.length = 0, return true
        if(s == null || s.length() == 0 || wordDict == null ||wordDict.size() == 0) return false;
        res = false;
        int start = 0;
        str = s;
        breakHelper(wordDict, start);
        return res;
    }
    private void breakHelper(List<String> wordDict, int start){
        if(res) return;
        if (str.length() == start) {
            res = true;
            return;
        }
        for(int i = start + 1; i <= str.length(); i++){
            if(wordDict.contains(str.substring(start,i))){//s.substring(i,i+len+1) equals to word
                breakHelper(wordDict, i);
            }
        }
    }
}



//solution 2
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];   
        f[0] = true;
        //DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}
