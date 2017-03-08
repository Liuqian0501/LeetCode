public class Solution {
    public int firstUniqChar(String s) {
        if(s == null) return -1;
        int len = s.length();
        int[] charTable = new int[26];
        //store s into charTable
        for(int i = 0; i < len; i++){
            charTable[s.charAt(i) - 'a'] ++;
        }
        
        //check and output the first char with charTable[s.charAt(i) - 'a'] = 1
        for(int i = 0; i < len; i++){
            if(charTable[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
