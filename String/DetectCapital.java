public class Solution {
    public boolean detectCapitalUse(String word) {
        int numUpper = 0;
        for (int i=0;i<word.length();i++) {
            if (Character.isUpperCase(word.charAt(i))) numUpper++;
        }
        if (numUpper == 1) return Character.isUpperCase(word.charAt(0));
        return numUpper == 0 || numUpper == word.length();
    }
}



//solution 2
public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0) return false;

        return checkAllCap(word) || checkAllNoCap(word) || checkFirstCap(word);
    }
    private boolean checkAllCap(String word){
        for(int i = 0; i<word.length(); i++){
            if(!Character.isUpperCase(word.charAt(i))) return false;
        }
        return true;
    }
    private boolean checkAllNoCap(String word){
        for(int i = 0; i<word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))) return false;
        }
        return true;
    }
    private boolean checkFirstCap(String word){
        for(int i = 1; i<word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))) return false;
        }
        return Character.isUpperCase(word.charAt(0));
    }
    
}
