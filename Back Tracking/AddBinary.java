public class Solution {
    public String addBinary(String a, String b) {
        // To solve binary adding problem, we need to use a carry 
        char carry = '0';
        String s = "";
        int lenA = a.length();
        int lenB = b.length();
        if(lenA > lenB){
            b = addZeros(b, lenA - lenB, ""); // add zeros to s + b
        }else{
            a = addZeros(a, lenB - lenA, ""); // add zeros to s + a
        }
        int len = a.length() - 1;
        
        while(len >= 0){
            if(a.charAt(len) == b.charAt(len)){
                s = carry + s;
                carry = (a.charAt(len) == '0') ? '0' : '1';
            }else{
                s = ((carry == '1') ? '0' : '1') + s;
                // carry still the same;
            }
            len--;
        }

        return (carry == '1')? '1' + s : s;
    }
    private String addZeros(String t, int n, String s){
        for(int i = 0; i < n; i++ ){
            s = s + "0";
        }
        t = s + t;
        return t;
    }
}
