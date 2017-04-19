public class Solution {
    public boolean isValid(String s) {
        // The key to solve this problem is to realize that there must be a '}',']'or ')' behind '{','[','('.
        // So it is easy to solve the problem if we can push a '{','[','(' to the stack every time we come across a '}',']'or ')', otherwise we
        // pop the up most element and compare that element with the element we come across.
        
        // First, we need a stack for char;
        Stack<Character> stack = new Stack<>();
        
        //we implement our algorithm 
        for(char c : s.toCharArray()){
            //push a '{','[','(' to the stack every time we come across a '}',']'or ')'
            if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '('){
                stack.push(')');
            }else if(stack.isEmpty() || stack.pop() != c ){
                return false;
            }
        }
        return stack.isEmpty()? true: false;
    }
}
