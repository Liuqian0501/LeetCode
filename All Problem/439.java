public class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Deque<Character> stack = new LinkedList<>();
    
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
    
                stack.pop(); //pop '?'
                char first = stack.pop();
                char second = stack.pop();
    
                if (c == 'T') stack.push(first);
                else stack.push(second);
            } else {
                if(c != ':' ) stack.push(c);
            }
        }
    
        return String.valueOf(stack.peek());
    }
}
