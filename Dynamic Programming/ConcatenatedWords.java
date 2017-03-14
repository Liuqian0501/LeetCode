public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // To solve this problem, we can call wordbreak for every element in the array and words is the dictionary itself.
        // We need to sort the array based on their length first
        //base case words = null , words.length < 3, return 
        List<String> list = new ArrayList<>();
        if(words == null || words.length < 3) return list;
        
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        boolean[] map;
        Set<String> wordsList = new HashSet<>();

        for(String word : words){
            map = new boolean[word.length() + 1];
            map[0] = true;
            if(breakable(word, wordsList, map))  
                list.add(word);
            wordsList.add(word);
        }
        return list;
    }
    private boolean breakable(String word, Set<String> words, boolean[] map){
        //check whether word is comprised entirely of at least two shorter words in words.
        if(word.length() == 0) return false; 
        for(int i = 1; i <= word.length(); i++){
            for(int j = 0; j < i; j++){
                if(map[j]){
                    if(words.contains(word.substring(j,i))){
                        map[i] = true;
                        break;
                    }
                }
            }
        }
        return map[word.length()];
    }
}
