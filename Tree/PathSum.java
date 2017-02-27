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
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        findPathSum(root, sum);
        return flag;
    }
    
    public void findPathSum(TreeNode root, int sum) {
        if(root == null) return;
        sum -= root.val;
        if(root.left != null) hasPathSum(root.left, sum);
        if(root.right != null) hasPathSum(root.right, sum);
        if(root.left == null && root.right == null && sum == 0) flag = true;
    }
}
 
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

