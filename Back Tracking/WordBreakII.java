public class Solution {
    boolean[] nonBreakable;
    public List<String> wordBreak(String s, List<String> wordDict) {
        //I am going to solve this problem using BackTracking/DFS
        //base case no s, no wordDict, s.length = 0
        //Case 1: no sub word in dictionary;
        //Case 2: one of them in dictionary; resursively call breakHelper for all word in wordDictionary
        
        // if new string.length = start, add string
        List<String> list = new ArrayList<>();
        if(s == null || s.length() == 0 || wordDict == null ||wordDict.size() == 0) return list;
        String s1 = "";
        nonBreakable = new boolean[s.length() + 1];
        breakHelper(s, wordDict, 0, s1 , list);
        return list;
    }
    private void breakHelper(String s, List<String> wordDict, int start, String s1, List<String> list){
        if (s.length() == start) {
            list.add(s1.substring(1));
            return;
        }
        int flag = 0;
        for(int i = start + 1; i <= s.length(); i++){
            if(nonBreakable[i]) continue;
            else if(wordDict.contains(s.substring(start,i))){//s.substring(i,i+len+1) equals to word
                breakHelper(s, wordDict, i, s1 + " " + s.substring(start,i), list);
                flag = 1;
            }
        }
        if(flag == 0) nonBreakable[start] = true;
    }
}
