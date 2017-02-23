import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 */

/**
 * @author LiuQianKevin
 *
 */
public class PascalsTriangle {

	/**
	 * @param args
	 */
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	int temp = 0;
    	for(int i = 0; i < numRows; i++){
    		List<Integer> list = new ArrayList<Integer>();
    		if(i<2){
    			for(int j = 0; j <= i; j++){
        			list.add(1);
        		}
    			triangle.add(list);
    		}else{
    			for(int j = 0; j <= i; j++){
    				if (j == 0 || j == i) {
    					list.add(1);
					}else{
						temp = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
						list.add(temp);
					}
        		}
    			triangle.add(list);
    		}
    		
    	}
		return triangle;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(0));
	}

}
