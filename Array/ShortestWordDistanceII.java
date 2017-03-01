public class WordDistance {
    /*
    Since we have to call the method multiple times, we need a algorithm with speed faster than theta(n) per call, we can store words in hashtable and distinct word as hashkey which takes theta(n), each call of shortest(word1,word2) take an index 
    list of word1 (O(n)) and word2 (O(n)) and find the min distance in O(n) 
    */
    Map<String, List<Integer>> hashMap;
    public WordDistance(String[] words) {
        // Store words in static hash table;
        hashMap = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!hashMap.containsKey(words[i])){
                hashMap.put(words[i],new ArrayList<Integer>());
            }
            hashMap.get(words[i]).add(i);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1List = hashMap.get(word1);
        List<Integer> word2List = hashMap.get(word2);
        Integer min = Integer.MAX_VALUE;

        //faster way for sorted array comparision
        int word1Size = word1List.size() , word2Size = word2List.size(),index1,index2;
        for(int i=0, j = 0; i<word1Size && j<word2Size;){
            index1 = word1List.get(i);
            index2 = word2List.get(j);
            if(index1 < index2){
                min = min < (index2 - index1) ? min : (index2 - index1);
                i++;
            }else{
                min = min < (index1 - index2) ? min : (index1 - index2);
                j++;
            }
        }
        
        //common array comparison
        for(Integer i : word1List){
            for(Integer j : word2List){
                min = min < Math.abs(i-j) ? min : Math.abs(i-j);
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
