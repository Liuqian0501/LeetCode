public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        // #two position buffer# #DP-min#
        int pos1 = -1,temp = -1, pos2 = -1, min = Integer.MAX_VALUE; // word not found
        for(int i = 0; i < words.length; i++){
            if(!word1.equals(word2)){
                if(words[i].equals(word1)) pos1 = i;
                if(words[i].equals(word2)) pos2 = i;
            }else{
                if(words[i].equals(word1)) {
                    temp = pos1;
                    pos1 = i;
                    pos2 = temp;
                }
            }
            if(pos1!=-1 && pos2!=-1){
                min = min < Math.abs(pos1-pos2) ? min : Math.abs(pos1 - pos2); 
            }
        }
        return min;
    }
}
