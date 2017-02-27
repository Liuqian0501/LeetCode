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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //Depth First Search, recursive
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        findAllLevel(list, root , 0);
        return list;
    }
    public void findAllLevel(List<List<Integer>> list, TreeNode root, int level){
        if(root == null) return;
        if(level+1 > list.size()){
            list.add(0,new LinkedList<Integer>());
        }
        if(root.right != null) findAllLevel(list, root.right, level + 1);
        if(root.left != null) findAllLevel(list, root.left, level + 1);
        
        list.get(list.size()-level-1).add(0,root.val);
    }
    
    
    
    
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
          //Breath First Search
          Queue<TreeNode> queue = new LinkedList<TreeNode>();
          List<List<Integer>> list = new LinkedList<List<Integer>>();
          if(root == null) return list;
          queue.offer(root);
          while(!queue.isEmpty()){
              int size = queue.size();
              List<Integer> subList = new LinkedList<>();
              for(int i=0; i < size; i++){
                  if(queue.peek().left != null) queue.offer(queue.peek().left);
                  if(queue.peek().right != null) queue.offer(queue.peek().right);
                  subList.add(queue.poll().val);
              }
              list.add(0,subList);
          }
          return list;
        }
}
