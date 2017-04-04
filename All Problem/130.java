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
    public void solve(char[][] board) {
        int len = board.length;
        if(len < 3) return;
        int width = board[0].length;
        if(width < 3) return;
        UnionFind uf = new UnionFind(len*width + 1);
        int dummy = len*width;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < width; j++){
                if((i==0||j==0||i==len - 1||j == width - 1)&&board[i][j] == 'O'){
                    uf.union(dummy, i*width+j);//connect bound to dummy
                }else if(board[i][j]=='O') // connect a 'O' node to its neighbour 'O' nodes
                {
                    if(board[i-1][j]=='O')
                        uf.union(i*width+j, (i-1)*width+j);
                    if(board[i+1][j]=='O')
                        uf.union(i*width+j, (i+1)*width+j);
                    if(board[i][j-1]=='O')
                        uf.union(i*width+j, i*width+j-1);
                    if(board[i][j+1]=='O')
                        uf.union(i*width+j, i*width+j+1);
                }
            }
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j < width; j++){
                if(!uf.connected(i*width+j, dummy)){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}
