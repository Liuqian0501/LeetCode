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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        else if(root.left == null || root.right == null) return false;
        
        //check 1level children
        if(root.left.val == root.right.val) return mirrorChecking(root.left, root.right);
        else return false;
    }
    
    public boolean mirrorChecking(TreeNode left, TreeNode right){
        // all children
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;
        
        if(left.val == right.val) return mirrorChecking(left.left, right.right) && mirrorChecking(left.right, right.left);
        else return false;
    }
}
