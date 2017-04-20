public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == k) return "0";//special case
        if(k == 0) return num;
        
        //greedy algorithm: at the top digit, whether we remove it is base on the next digit
        //e.g. 123, k = 1, we don't remove 1 cause 2 is lager, 213, we remove 2 since 2 > 1
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< len; i++){
            while(k > 0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        //move digit to remove : remove from the end
        while(k>0){
            stack.pop();
            k--;
        }
    
        //no need to reverse
        char[] charArray = new char[stack.size()];
        for(int i = stack.size()-1; i>-1 ; i--){
            charArray[i] = stack.pop();
        }
        
        //skip zeros
        String s = new String(charArray);
        int i = 0;
        while(s.charAt(i) == '0'&& i < charArray.length - 1){
            i++;
        }
        
        return s.substring(i);
    }
}
