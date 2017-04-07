//https://leetcode.com/problems/word-break/#/description
public class Solution {
    boolean res;
    public boolean wordBreak(String s, List<String> wordDict) {
        //I am going to solve this problem using DFS
        //base case no s, no wordDict, s.length = 0
        //Case 1: no sub word in dictionary;
        //Case 2: one of them in dictionary; resursively call breakHelper(s.substring(0,i+1)+marker+ s.substring(i+1), wordDict) for all word in wordDictionary
        
        // if new string.length = 0, return true
        if(s == null || s.length() == 0 || wordDict == null ||wordDict.size() == 0) return false;
        boolean[] hashSet = new boolean[s.length()];
        res = false;
        int start = 0;
        breakHelper(s,wordDict, start,hashSet);
        return res;
    }
    private void breakHelper(String s, List<String> wordDict, int start,boolean[] hashSet){
        if(res) return;
        if (s.length() == start) {
            res = true;
            return;
        }
        for(int i = start + 1; i <= s.length(); i++){
            if(hashSet[i-1])
                continue;
            else if(wordDict.contains(s.substring(start,i))){//s.substring(i,i+len+1) equals to word
                hashSet[i-1] = true;
                breakHelper(s, wordDict, i, hashSet);
            }
        }
    }
}
