public class Solution {
    boolean res;
    public boolean wordBreak(String s, List<String> wordDict) {
        //I am going to solve this problem using BFS
        //base case no s, no wordDict, s.length = 0
        //Case 1: no sub word in dictionary;
        //Case 2: one of them in dictionary; resursively call breakHelper(s.substring(0,i+1)+marker+ s.substring(i+1), wordDict) for all word in wordDictionary
        
        // if new string.length = 0, return true
        if(s == null || s.length() == 0 || wordDict == null ||wordDict.size() == 0) return false;
        res = false;
        breakHelper(s, wordDict, s.length());
        return res;
    }
    private void breakHelper(String s, List<String> wordDict, int remain){
        if (remain == 0) {
            res = true;
            return;
        }
        if(res) return;
        for(String word : wordDict){
            int len = word.length();
            for(int i = 0; i + len - 1 < s.length(); i++){
                if(word.equals(s.substring(i,i+len))){//s.substring(i,i+len+1) equals to word
                    String newS = s.substring(0,i) + marker(len) + s.substring(i+len);
                    breakHelper(newS, wordDict, remain - len);
                }
            }
        }
    }
    private String marker(int len){
        String s = "";
        for(int i = len; i > 0; i--){
            s = s + '&'; 
        }
        return s;
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
