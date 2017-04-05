https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/#/description
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        int len = s.length();
        if(len == 0) return s;
        char[] charString = s.toCharArray();
        //go through the list
        String max = "";
        for(String str : d){
            if(str.length() < max.length() || (str.length() == max.length() && str.compareTo(max) > 0)) continue;
            int i = 0;
            // magic comparison
            for(char c : charString){
                if(i < str.length() && str.charAt(i) == c) i++;
            }
            if(i == str.length()) max = str;
        }
        return max;
    }
}
