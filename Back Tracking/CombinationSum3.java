public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        combination(list, new ArrayList<>(), n, 9, k);
        return list;
    }
    public void combination(List<List<Integer>> list, List<Integer> subList, int target, int len, int k){
        if(target < 1) return;
        for(int cand = len; cand > 0; cand--){
            if(cand > target) continue;
            else{
                List<Integer> newList = new ArrayList<>(subList);
                newList.add(cand);
                if ( cand == target && k == 1) 
                    list.add(newList); 
                else if (k >= 1) combination(list, newList, target - cand, cand - 1, k - 1);
            } 
        }
    }
}
