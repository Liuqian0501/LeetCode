public class Solution {
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47,
                    53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//10609 z maximum
    Map<Integer, Integer> hashMap = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        int key;
        List<List<String>> list = new ArrayList<>();
        List<String> subList;
        for(String str : strs){
            key = 1;
            for(char c : str.toCharArray()){
                key *= prime[c - 'a'];
            }
            if(hashMap.containsKey(key)){
                list.get(hashMap.get(key)).add(str);
            }else{
                subList = new ArrayList<>();
                hashMap.put(key,list.size());
                subList.add(str);
                list.add(subList);
            }
        }
        return list;
    }
}
