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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        if(Math.abs(maxLeft - maxRight) > 1 ) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left == 0 || right == 0) ? left + right +1: (left > right ? left + 1:right + 1 );
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
    public boolean isBalanced(TreeNode root) {
        int max = maxDepth(root);
        int min = minDepth(root);
        System.out.println(max + " " + min);
        return max - min > 1 ? false : true;
    }
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left == 0 || right == 0) ? left + right +1: (left > right ? left + 1:right + 1 );
    }
    
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        int left =  minDepth(root.left);
        int right =  minDepth(root.right);
        return (left == 0 || right == 0) ? 1 : (left < right ? left + 1:right + 1 );
    }
}
