https://leetcode.com/problems/palindrome-permutation-ii/#/description
public class Solution {
    public List<String> generatePalindromes(String s) {
        // First find out all possible string that can be made from s
        // check those strings and return those palindromic permutations
        //speed n!
        if(s == null) return null;
        List<String> list = new ArrayList<>();
        int len = s.length();
        if(len < 2){
            list.add(s);
            return list;
        }
        char[] charArray = s.toCharArray();
        boolean[] choice = new boolean[len];//define a choice set
        Arrays.sort(charArray);
        helper("", len, charArray, choice, list);
        return list;
    }
    private void helper(String prefix, int len, char[] charArray, boolean[] choice, List<String> list){
        if(len == 0){
            if(checkPalindromes(charArray.length, prefix)) list.add(prefix);
            return;
        }
        char lastVisit = ' ';
        for(int i = 0; i < charArray.length; i++){
            if(choice[i] | charArray[i] == lastVisit) continue;
            else{
                choice[i] = true;
                helper(prefix + charArray[i], len - 1, charArray, choice, list);
                choice[i] = false;
                lastVisit = charArray[i];
            }
        }
    }
    private boolean checkPalindromes(int len, String s){
        int mid = (len - 1)/2;
        for(int i = 0; i <= mid; i++){
            if(s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        return true;
    }
}
