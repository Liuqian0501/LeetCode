public class Solution {
    int start = 0;
    int len = 0;
    public String longestPalindrome(String s) {
        //To solve this problem, pharse through s and find longest palindrome based on each char
        //If longest palindrome is odd, compare(i,i), otherwise compare(i,i+1)
        //base case s = null or length == 0
        if(s == null || s.length() < 2) return s;
        for(int i = 0; i < s.length() - 1; i++){
            if(2*(s.length() - i) - 1 <  len) break;
            compare(s, i, i);
            compare(s, i, i+1);
        }
        //System.out.println(start+ "start "+ len);
        return s.substring(start, start + len);
    }
    private void compare(String s, int j, int k){
        while(j>= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        //System.out.println(j + " " + k);
        if(k - j - 1 > len){
            start = j + 1;
            len = k - j - 1;
        }
    }
}
