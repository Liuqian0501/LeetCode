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
    public TreeNode str2tree(String s) {
        // To solve this problem, we implement BFS, find the first and second () for each root
        // There is a case that no () in s;
        if(s == null || s.length() == 0) return null;
        int count = 0; // count pair of '()'
        int left = 0; // flag for left child
        int index = 0; // marker of the begining of subtree 
        
        TreeNode root = new TreeNode(0);
        
        if(s.charAt(s.length() - 1) != ')') //no () in s
            root.val = Integer.valueOf(s.substring(0));
        else{
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '(' ){
                    if(count == 0 ){// begin of new subtree
                        index = i;
                        if(left == 0){ // left subtree
                            root.val = Integer.valueOf(s.substring(0,i));
                        }
                    }
                    count++;
                }
                if(s.charAt(i) == ')'){
                    count--;
                    if(count == 0){// end of new subtree
                        if(left == 0){
                            root.left = str2tree(s.substring(index + 1,i));
                            left = 1;
                        } 
                        else root.right = str2tree(s.substring(index + 1,i));
                    }
                }
            }
        }

        return root;
    }
}
