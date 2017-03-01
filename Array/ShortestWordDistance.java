// #position buffer#    #DP - Min#
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int buffer1 = -1 , buffer2 = -1, min = Integer.MAX_VALUE;
        for(int i = 0 ; i < words.length ; i++){
            //record position
            buffer1 = words[i].equals(word1) ? i : buffer1;
            buffer2 = words[i].equals(word2) ? i : buffer2;
            if(buffer1 >= 0 && buffer2 >= 0) min = min < Math.abs(buffer1 - buffer2) ? min : Math.abs(buffer1 - buffer2);
        }
        return min;
    }
}
