package hashTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class NumberofBoomerangs {
    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i==j) {
					continue;
				}else {
					int dist = distanceCalculation(points[i],points[j]);
					map.put(dist, map.getOrDefault(dist, 0)+1);
				}
			}
			for(int mapVal : map.values()){
				result += mapVal * (mapVal-1); 
			}
			map.clear();
		}
		return result;
        
    }
	private static int distanceCalculation(int[] is, int[] is2) {
		// TODO Auto-generated method stub
		int dx = is[0] - is2[0];
		int dy = is[1] - is2[1];
		return dx*dx + dy*dy;
	}
	public static void main(String args[]) {
		int[][] str = {{0,0},{1,0},{2,0}};
    	long startTime = System.nanoTime();
    	int a = numberOfBoomerangs(str);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	System.out.println(a);
	}
}
