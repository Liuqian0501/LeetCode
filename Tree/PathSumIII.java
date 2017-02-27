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
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        pathSum1(root, sum);
        return res;
    }
    public void pathSum1(TreeNode root, int sum) {
        if(root == null) return;
        subPathSum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right,sum);
    }
    
    public void subPathSum(TreeNode root, int sum){
        if(root == null) return;
        if(root.val == sum)  res++;
        subPathSum(root.left, sum - root.val);
        subPathSum(root.right, sum - root.val);
    }
}



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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return subPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right,sum);
    }
    
    public int subPathSum(TreeNode root, int sum){
        if(root == null) return 0;
        return (root.val == sum ? 1:0) + subPathSum(root.left, sum - root.val) + subPathSum(root.right, sum - root.val);
    }
}
