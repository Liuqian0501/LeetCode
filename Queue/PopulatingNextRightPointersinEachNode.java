/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        //we implement queue to solve this kind of problem, at each level we can connect nodes from left to right,and at the same time, we can offer node to queue from left to right
        //connectLevel(root, queue);
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if(root == null) return;
        queue.offer(root);
        int size = queue.size();
        TreeLinkNode firstPoll, secondPoll;
        while(size != 0){
            for(int i = 0; i < size; i++){
                firstPoll = queue.poll();
                if(i == size - 1) 
                    firstPoll.next = null;
                else 
                    firstPoll.next = queue.peek();
                if(firstPoll.left != null) queue.offer(firstPoll.left);
                if(firstPoll.right != null) queue.offer(firstPoll.right);
            }
            size = queue.size();  
        }
    }

}
