public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combination(list, new ArrayList<>(), candidates, target, candidates.length-1);
        return list;
    }
    public void combination(List<List<Integer>> list, List<Integer> subList, int[] candidates, int target, int len){
        if(target < candidates[0]) return;
        for(int cand = len; cand >=0; cand--){
            if(candidates[cand] > target) continue;
            else{
                // find the first element that is smaller than target.
                List<Integer> newList = new ArrayList<>(subList);
                newList.add(candidates[cand]);
                if ( candidates[cand] == target) 
                    list.add(newList); 
                else  
                    combination(list, newList, candidates, target - candidates[cand], cand);
                
            } 
        }
    }
}
