/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        list = new LinkedList<List<Integer>>();
        if(root == null) return list;
        List<Integer> subSum = new LinkedList<Integer>();
        findSum(root, subSum, sum);
        return list;
    }
    
    public void findSum(TreeNode root,List<Integer> subSum, int sum){
        subSum.add(root.val);
        sum -=  root.val;
        if(root.left != null) findSum(root.left, new LinkedList(subSum), sum);
        if(root.right != null) findSum(root.right, new LinkedList(subSum) , sum);
        if(root.left == null && root.right == null && sum == 0) list.add(new LinkedList(subSum));
    }
}
