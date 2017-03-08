public class Solution {
    public boolean isStrobogrammatic(String num) {
        //we can use stack to solve this kind of problem(FILO). If the number's length is odd, then the middle has to be 1 or 0,8,
        //all elements have to be one of {1,6,8,9,0}
        Stack<Character> stack = new Stack<>();
        char[] table = new char[256];
        table['0'] = 2; table['1'] = 2;   table['6'] = 1;   table['8'] = 2;   table['9'] = 3;
        
        if(num == null) return false;
        int len = num.length();
        if(len == 0) return true;
        int mid = (len - 1)/2;
        
        //Add first half to stack;
        char c;
        if(len % 2 == 1){//odd
            if(table[num.charAt(mid)] != 2) 
                return false;
            for(int i = 0; i < mid; i++){
                c = num.charAt(i);
                if(table[c] == 0) 
                    return false;
                else if(table[c] == 2) 
                    stack.push(num.charAt(i));
                else if(table[c] == 3) 
                    stack.push('6');
                else
                    stack.push('9');
            }
        }else{//even
            for(int i = 0; i <= mid; i++){
                c = num.charAt(i);
                if(table[c] == 0) 
                    return false;
                else if(table[c] == 2) 
                    stack.push(num.charAt(i));
                else if(table[c] == 3) 
                    stack.push('6');
                else
                    stack.push('9');
            }
        } 
        
        //check second half to stack;
        for(int i = mid + 1; i < len; i++){
            if(stack.isEmpty() || stack.pop() != num.charAt(i)) return false;
        }
        return true;
    }
}
