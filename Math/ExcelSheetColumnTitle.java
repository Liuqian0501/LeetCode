public class Solution {
    public String convertToTitle(int n) {
        String s = "";
        while(n > 0){
            s =  (char) (65 + --n%26) + s;
            n /= 26;
        }
        return s;
    }
}
