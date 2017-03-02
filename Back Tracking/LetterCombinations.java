public class Solution {
    private static final String[] Keyboard = { "", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0) return list;
        combination("",digits, list, 0);
        return list;
    }
    private void combination(String prefix, String digits, List<String> list,int i){
        if(i >= digits.length()){
            list.add(prefix);
            return;
        }
        String s = Keyboard[digits.charAt(i) - '0'];
        //nothing will be added to list if s == ""
        for(int j=0; j< s.length(); j++){
            combination(prefix + s.charAt(j), digits, list, i+1);
        }
    }
}
