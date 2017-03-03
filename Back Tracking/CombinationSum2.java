public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                List<Integer> newList = new ArrayList<>(subList);
                newList.add(candidates[cand]);
                if ( candidates[cand] == target)
                    //skip same and add Unique
                    if(cand >= 1 && candidates[cand] == candidates[cand - 1]) 
                        continue;
                    else 
                        list.add(newList); 
                else{
                    //skip same
                    if(cand <= len-1 && candidates[cand] == candidates[cand + 1]) 
                        continue;
                    else 
                        combination(list, newList, candidates, target - candidates[cand], cand-1);
                }
            } 
        }
    }
}
