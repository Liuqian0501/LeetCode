//https://leetcode.com/problems/friend-circles/#/description
public class Solution {
    class UnionFind {
        private int[] parent,rank;//rank = level of that node, parent[i] = parent of node i
        private int count = 0;
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
        }
        
        public int find(int p) {
            if(parent[p] == -1) return p;
            return find(parent[p]);
        }
        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ ? true : false;//connected or not
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;//same set
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;//rootQ is our new root
            }
            else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;//rootP is our new root
                }
            }
            count--;
        }
        public int count(){
            return count;
        }

    }
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {//last student has been included
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}
