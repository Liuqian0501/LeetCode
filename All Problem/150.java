public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> val = new Stack<>();
        for(String s : tokens){
            switch(s){
                case "+":
                    val.push(Integer.valueOf(val.pop()) + Integer.valueOf(val.pop()));
                    break;
                case "-":
                    val.push( -Integer.valueOf(val.pop()) + Integer.valueOf(val.pop()));
                    break;
                case "*":
                    val.push(Integer.valueOf(val.pop()) * Integer.valueOf(val.pop()));
                    break;
                case "/":
                    Integer first = Integer.valueOf(val.pop());
                    val.push(Integer.valueOf(val.pop())/first);
                    break;
                default:
                    val.push(Integer.valueOf(s));
                    break;
            }
        }
        return val.peek();
    }
}
