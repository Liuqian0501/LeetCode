public class Solution {
    public String reverseString(String s) {
        int len = s.length();
        char[] charString = new char[len];
        for(int i = 0; i < len; i++){
            charString[len-i-1] = s.charAt(i);
        }
        return new String(charString);
    }
}
