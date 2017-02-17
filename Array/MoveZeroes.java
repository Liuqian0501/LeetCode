


public class MoveZeroes {
	//solu1
	public static void moveZeroes(int[] nums) {
		    if (nums == null || nums.length == 0) return;        

		    int insertPos = 0;
		    for (int num: nums) {
		        if (num != 0) nums[insertPos++] = num;
		    }        

		    while (insertPos < nums.length) {
		        nums[insertPos++] = 0;
		    }
    }
	/*Solu 2 */
	public static void moveZeroes2(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0){
	        	nums[insertPos] = num;
	        	insertPos++;
	        }
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos] = 0;
	        insertPos++;
	    }
	}
	
	public static void main(String args[]) {
		int[] intput = {12,1,0,3,0};
    	long startTime = System.nanoTime();
    	moveZeroes2(intput);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	
    	int[] intput2 = {12,1,0,3,0};
    	long startTime2 = System.nanoTime();
    	moveZeroes(intput2);
    	long endTime2 = System.nanoTime();
    	System.out.println("Took "+(endTime2 - startTime2) + " ns"); 
    	//System.out.println(a.toString());
	}
}
