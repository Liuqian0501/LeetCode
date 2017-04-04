//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/#/description
public class Solution {
    public int countComponents(int n, int[][] edges) {
      // initialize n isolated islands
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int len = edges.length;
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(parent, edges[i][0]);
            int y = find(parent, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) {
                len--;
                continue;
            }
            // union
            parent[x] = y;//y is our new root now
        }
        
        return n - len;//for a valid tree with n node, there must be n - 1 edges
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
