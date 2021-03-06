/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        //index of left = root*2+1; right = left + 1
        Map<Integer, Integer> map = new HashMap<>();
        map.put(-1, Integer.MIN_VALUE);
        pharseTree(root,0,map);
        int size = map.get(-1)+1;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i< size; i++){
            if(map.containsKey(i)){
                res.append(map.get(i)+" "); 
            }else{
                res.append("n ");
            }
        }
        //System.out.println(Arrays.toString(c));
        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] ary = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ary[0]));
        root.left = buildTree(ary, 1);
        root.right = buildTree(ary,2);
        return root;
    }
    private void pharseTree(TreeNode root, int index, Map<Integer, Integer> hashMap){
        hashMap.put(index, root.val);
        if(index > hashMap.get(-1)) hashMap.put(-1,index);
        if(root.left != null){
            pharseTree(root.left, 2*index +1, hashMap);
        }
        if(root.right != null){
            pharseTree(root.right, 2*index + 2, hashMap);
        }
    }
    private TreeNode buildTree(String[] ary, int index){
        if(index > ary.length - 1 ) {
            return null;
        }
        String a = ary[index];
        if(a.equals("n")){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(a));
            node.left = buildTree(ary, 2*index + 1);
            node.right = buildTree(ary, 2*index + 2);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
