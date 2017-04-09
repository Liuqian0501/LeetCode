//https://leetcode.com/problems/unique-substrings-in-wraparound-string/#/description
public class Solution {
    public int findSubstringInWraproundString(String p) {
        int len = p.length();
        if(len == 0) return 0;
        int[] N = new int[len];//N[i] # of substring end with p.charAt(i)
        N[0] = 1;
        int sum = 1;
        int[] record = new int[26];//record[i] max length of substring end with p.charAt(i)
        record[p.charAt(0) - 'a']++;
        for(int i = 1; i < len; i++){
            char c = p.charAt(i);
            if(c - p.charAt(i-1) == 1 || c - p.charAt(i-1) == -25)
                N[i] = N[i-1]+1;
            else{
                N[i] = 1;
            }
            if(record[c - 'a'] < N[i]){
                sum += N[i] - record[c-'a'];
                record[c-'a'] = N[i];
            }
        }
        return sum;
    }
}
