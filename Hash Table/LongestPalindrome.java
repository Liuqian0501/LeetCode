public class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 0 || s == null) return 0;
        int count = 0;
        int[] charHash = new int[128];
        for(int i = 0; i <s.length(); i++){
            if(charHash[s.charAt(i)] == 1){
                charHash[s.charAt(i)] = 0;
                count++;
            }else{
                charHash[s.charAt(i)] = 1;
            }
        }
        int flag = 0;
        for(int i : charHash){
            if(i == 1){
                flag = 1;
                return 2*count+ flag;
            }
        }
        return 2*count+ flag;
    }
}
