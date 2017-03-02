public class Solution {
    private static Set<String> winSet = new HashSet<>();
    private static Set<String> lossSet = new HashSet<>();
    
    public boolean canWin(String s) {
        if(s == null || s.length() < 2){
            return false;
        }
        if(lossSet.contains(s)){
            return false;
        }
        if(winSet.contains(s)){
            return true;
        }
        for(int i = 0; i< s.length() - 1; i++){
            if(s.startsWith("++", i)){
                String t = s.substring(0, i) + "--" + s.substring(i + 2);

                if(!canWin(t)){
                    lossSet.add(t);
                    winSet.add(s);
                    return true;
                }else{
                    winSet.add(t);
                }
            }
        }

        lossSet.add(s);
        return false;
    }
}
