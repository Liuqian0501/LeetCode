https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
public class Solution {
    private static final String[] Keyboard = { "", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private static List<String> list;
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if(digits.length() == 0) return list;
        combination("",digits, 0);
        return list;
    }
    private void combination(String prefix, String digits, int i){
        if(i >= digits.length()){
            list.add(prefix);
            return;
        }
        String s = Keyboard[digits.charAt(i) - '0'];
        //nothing will be added to list if s == ""
        for(int j=0; j< s.length(); j++){
            combination(prefix + s.charAt(j), digits, i+1);
        }
    }
}
