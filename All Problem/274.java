//https://leetcode.com/problems/h-index/#/description
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = citations.length - 1; i >= 0; i--){
            if(citations[i] < citations.length - i) {
                return citations.length - i - 1;
            }
        }
        return citations.length;
    }
}


//solution 2
public int hIndex(int[] citations) {
    int len = citations.length;
    int[] count = new int[len + 1];
    
    for (int c: citations)
        if (c > len) 
            count[len]++;
        else 
            count[c]++;
    
    
    int total = 0;
    for (int i = len; i >= 0; i--) {
        total += count[i];
        if (total >= i)
            return i;
    }
    
    return 0;
}
