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
    // Without the knowledge that the minDiff exist in adjacent nodes.
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        // for each root, we need to compare it with the right-left most child and left-right most child and their left and rigth.
        findMinLeft(root, root.left);
        findMinRight(root, root.right);
        return minDiff;
    }
    private void findMinLeft(TreeNode root, TreeNode left){
        if(left == null) return;
        TreeNode leftCopy = left;
        while(leftCopy.right != null){
            leftCopy = leftCopy.right;
        }
        int diff = root.val - leftCopy.val;
        minDiff = diff < minDiff ? diff : minDiff;
        findMinLeft(left, left.left);
        findMinRight(left, left.right);
    }
    private void findMinRight(TreeNode root, TreeNode right){
        if(right == null) return;
        TreeNode rightCopy = right;
        while(rightCopy.left != null){
            rightCopy = rightCopy.left;
        }
        int diff = rightCopy.val - root.val;
        minDiff = diff < minDiff ? diff : minDiff;
        findMinLeft(right, right.left);
        findMinRight(right, right.right);
    }
}




//solution 2
public class Solution {
    // Without the knowledge that the minDiff exist in adjacent nodes.
    public int getMinimumDifference(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        goThroughTree(list,root);
        minDiff = findMin(list,minDiff);
        return minDiff;
    }
    private void goThroughTree(List<Integer> list, TreeNode root){
        if(root == null) 
            return;
        list.add(root.val);
        goThroughTree(list, root.left);
        goThroughTree(list, root.right);
    }
    private int findMin(List<Integer> list, int minDiff){
        Collections.sort(list);
        int tempDiff;
        for(int i = 1; i < list.size(); i++){
            tempDiff = list.get(i) - list.get(i-1);
            minDiff = (minDiff < tempDiff) ? minDiff : tempDiff;
        }
        return minDiff;
    }
}
