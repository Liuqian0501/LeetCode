public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        
        List<String> list = new ArrayList<>();
        if(s == null || s.length() < 2) return list;
        int len = s.length();
        String t;
        for(int i = 0; i+2 <= len; i++){
            if(s.startsWith("++", i)){
                t = s.substring(0,i) + "--" + s.substring(i + 2);
                list.add(t);
            }
        }
        return list;
    }
}
