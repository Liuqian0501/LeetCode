

/*
 * @authur Qian Liu
 */
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
    	int width = grid.length, length = grid[0].length;
    	int neighbours=0 , island = 0;
    	for(int i=0;i<width;i++){
    		for (int j = 0; j < length; j++) {
				if (grid[i][j]==1) {
					island++;
					if (j<length-1&&grid[i][j+1]==1)neighbours++;
					if (i<width-1 && grid[i+1][j]==1)neighbours++;
				}
			}
    	}
        return 4*island - 2*neighbours;
    }
	public static void main(String args[]) {
		int[][] str = {{0,1,0,0,0},{1,1,1,0,0},{0,1,0,0,0},{1,1,0,0,0}};
    	long startTime = System.nanoTime();
    	int a = islandPerimeter(str);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	System.out.println(a); 
    	//System.out.println(a.toString());
	}
}
