public class Solution {
    int len;
    int width;
    public int numIslands(char[][] grid) {
        //I am going to implement a DepthFirst Search\
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        len = grid.length;
        width = grid[0].length;
        int island = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j]=='1'){
                    island++;
                    sink(i,j,grid);
                }
            }
        }
        return island;
    }
    private void sink(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i >= len || j >= width || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        sink(i+1,j,grid);sink(i-1,j,grid);
        sink(i,j+1,grid);sink(i,j-1,grid);
    }
}
