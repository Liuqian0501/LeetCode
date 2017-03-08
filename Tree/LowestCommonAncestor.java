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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(p == null || q == null || root == null) return null;
        
        TreeNode temp;
        if(p.val > q.val){
            temp = q;
            q = p;
            p = temp;
        }
        
        //p and p have to be left and right of root
        if(p.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if(q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
