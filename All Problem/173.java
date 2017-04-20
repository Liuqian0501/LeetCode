/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
        Stack<TreeNode> stack = null;
        TreeNode node = null;
    	
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            node = root;
    	}
    
    	/** @return whether we have a next smallest number */
    	public boolean hasNext() {		  
            return !stack.isEmpty() || node != null; 
    	}
    
    	    /** @return the next smallest number */
    	public int next() {
            //if cur node is not null, push the left to stack
            if(node != null){
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
            TreeNode temp = stack.pop();
            node = temp.right;// next node we are looking at
            return temp.val;
            
    	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
