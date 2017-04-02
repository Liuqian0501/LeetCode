public class Solution {
    https://leetcode.com/problems/permutations/#/description
    
    //The basic idea is to check every value at each position, if index i can have value n, then remove n from the choice set and solve the subproblem using the same algothm. Complete choice property.
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        boolean[] choice = new boolean[nums.length];//define a choice set
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(nums.length, nums, choice, list, list2);
        return list;
    }
    private void helper(int len, int[] nums,boolean[] choice, List<List<Integer>> list, List<Integer> list2){
        if(list2.size() == len){
            list.add(list2);
            return;
        }
        for(int i = 0; i< len; i++){
            if(choice[i]) continue;
            choice[i] = true;
            List<Integer> newList = new ArrayList<>(list2);
            newList.add(nums[i]);
            helper(len, nums, choice, list, newList);
            choice[i] = false;
        }
    }
}
