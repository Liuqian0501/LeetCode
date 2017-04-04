//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/#/description
public class Solution {
    public int countComponents(int n, int[][] edges) {
      // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        int len = edges.length;
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) {
                len--;
                continue;
            }
            // union
            nums[x] = y;
        }
        
        return n - len;//for a valid tree with n node, there must be n - 1 edges
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
