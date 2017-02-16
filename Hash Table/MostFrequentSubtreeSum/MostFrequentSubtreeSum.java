package mostFrequentSubtreeSum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * @author LiuQian
 */
public class MostFrequentSubtreeSum {
	static HashMap<Integer, Integer> countSum;
	static int max;
	public static int[] findFrequentTreeSum(TreeNode root) {
		max = 0;
		countSum = new HashMap<Integer,Integer>();
		subtreeSum(root);
		List<Integer> res = new ArrayList<>();
		for (int sum : countSum.keySet()) {
			if (countSum.get(sum) == max) {
				res.add(sum);
				//System.out.println(sum);
			} 
	    }
		int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
	        
	        
	}
	private static int subtreeSum(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) return 0;
		int left = subtreeSum(root.left);
		int right = subtreeSum(root.right);
		int sum = left + right + root.val;
		int count = countSum.getOrDefault(sum, 0) + 1;
		countSum.put(sum, count);
		//System.out.println(max);
		max = Math.max(max, countSum.get(sum));
		return sum;
	}
	
	public static void main(String args[]) {
		TreeNode aNode = new TreeNode(2);
		TreeNode bNode = new TreeNode(-3);
		TreeNode cNode = new TreeNode(5);
		cNode.left = aNode;
		cNode.right = bNode;
		long startTime = System.nanoTime();
		int[] m = findFrequentTreeSum(cNode);
		System.out.println(m.length);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime)+ " ns"); 
    	//System.out.println(a.toString());
	}
}
