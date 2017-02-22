
import java.util.HashMap;
import java.util.Map;


/*
 * @authur Qian Liu
 */

public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    // add items to hashmap in order
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i ;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i );
	    }
	    return result;
    }
	public static void main(String args[]) {
		int[] str = {3,2,4};
    	long startTime = System.nanoTime();
    	int[] a = twoSum(str,6);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	for (int i : a) {
    		System.out.print(i + " ");
		}
	}
}
