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


//solution 3
public class Solution {
    public boolean isAnagram(String s, String t) {

        //we can use prime Map (for group)
        int[] primeMap = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53,
                            59, 61, 67, 71, 73, 79, 83, 89, 97, 101,103};//maximum 10609 z;
        int slen = s.length();
        int tlen = t.length();
        System.out.println(slen);
        if(slen != tlen) return false;
        int k1 = 1 , k2 = 1;
        for(int i = 0; i < slen; i++){
            k1 *= primeMap[s.charAt(i) - 'a'];
            k2 *= primeMap[t.charAt(i) - 'a'];
        }
        
        return (k1 == k2) ? true : false;
    }
}
