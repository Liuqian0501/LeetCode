/*
 * @authur Qian Liu
 */

public class ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
    	int prod = 1;
    	int numZeros = 0;
    	for(int i:nums){
    		if (i==0) {
				numZeros++;
				continue;
			}
    		prod *=i;
    	}
    	for (int i = 0; i < nums.length; i++) {
    		if (numZeros!=0) {
    			if (nums[i] == 0 && numZeros == 1) {
    				nums[i] = prod;
    			}else {
					nums[i]=0;
				}
			}else {
				nums[i]=prod/nums[i];
			}	
		}
		return nums;
        
    }
	public static void main(String args[]) {
		int[] str = {1,2,3,4,5};
    	long startTime = System.nanoTime();
    	int[] a = productExceptSelf(str);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	for (int i : a) {
    		System.out.print(i+" ");
		}
	}
}
