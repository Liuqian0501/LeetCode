public class Solution {
    public String addStrings(String num1, String num2) {
        // we need to add the string char by char, we need carrier 

        int carrier = 0;
        int len1 = num1.length()-1, len2 = num2.length()-1;
        String s = "";
        int val = 0;
        char c;
        int a = 0, b = 0;
        while(len1 >= 0 || len2 >= 0 || carrier ==1){
            a = len1 >= 0 ? num1.charAt(len1--) - '0' : 0;
            b = len2 >= 0 ? num2.charAt(len2--) - '0' : 0;
            val = a + b + carrier;
            carrier = val/10;
            c = (char) (val - carrier*10 + '0');
            s = c + s;
        }

        return s;
    
    }

}
