import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 */

/**
 * @author LiuQianKevin
 *
 */
public class PascalsTriangleII {

	/**
	 * @param args
	 */
    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> list = new ArrayList<Integer>();
    	if (rowIndex < 0)
    		return list;

    	for (int i = 0; i < rowIndex + 1; i++) {
    		//add 
    		list.add(0, 1); 
    		//set
    		for (int j = 1; j < list.size() - 1; j++) {
    			list.set(j, list.get(j) + list.get(j + 1));
    			System.out.println(list.get(j + 1));
    		}
    	}
    	return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(1));
	}

}
