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
    List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        list = new LinkedList<>();
        findPath(root,"");
        return list;
    }
    
    public void findPath(TreeNode root, String s){
        if(root == null) return;
        if(root.left != null)   findPath(root.left, s  + root.val + "->");
        if(root.right != null)  findPath(root.right, s + root.val + "->" );
        if(root.left == null && root.right == null) list.add(s + root.val);
    }
}
