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
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        findMin(root,1);
        return min;
    }
    
    public void findMin(TreeNode root, int depth){
        if(root == null) return;
        if(root.left != null)  findMin(root.left,depth + 1);
        if(root.right != null)  findMin(root.right, depth + 1);
        if(root.left == null && root.right == null) min = min < depth ? min : depth; 
    }
}


public class Solution {

    public int minDepth(TreeNode root) {
      if(root == null) return 0;
      int left = minDepth(root.left);
      int right = minDepth(root.right);
      return (left == 0 || right == 0) ? left + right + 1 : (left < right ?  left + 1 : right + 1);
    }
    

}
