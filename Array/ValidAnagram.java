public class Solution {
    public boolean isAnagram(String s, String t) {

        //we can use char map
        int[] charMap = new int[26];
        int slen = s.length();
        int tlen = t.length();
        if(slen != tlen) return false;
        for(int i = 0; i < slen; i++){
            charMap[s.charAt(i) - 'a']++;
            charMap[t.charAt(i) - 'a']--;
        }
        int sum = 0;
        for(int i : charMap){
            if(i != 0) return false;
        }
        return true;
    }
}


//solution2
public class Solution {
    public boolean isAnagram(String s, String t) {
        // we can compare the char array
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        s = new String(sArray);
        t = new String(tArray);
        return s.equals(t);
    }
}
