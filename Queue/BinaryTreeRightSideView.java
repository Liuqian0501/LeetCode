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
    public List<Integer> rightSideView(TreeNode root) {
        // To solve this problem, we use a queue to store all node that the same level and add the first poped out node.val
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return list;
        queue.offer(root);
        int size = queue.size();
        TreeNode temp;
        while(size != 0){
            for(int i = 0; i < size; i++){
                temp = queue.poll();
                if(i == 0) list.add(temp.val);
                if(temp.right != null) queue.offer(temp.right);
                if(temp.left != null) queue.offer(temp.left);
            }
            size = queue.size();
        }
        return list;
    }

}
