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
        //I am going to implement a Back Tracking algorithm
        //There are three cases, 
        //the first case: p and q in subtree of root, return subtree; second case: p is left child of root and q is rigth child, return root
        //the third case: p, q not in subtree of root, return null;
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null){
            if(right == null) return null; // Third case
            else return right; //First case
        }else{
            if(right == null) return left; //First case
            else return root; // Second case
        }
    }
}
