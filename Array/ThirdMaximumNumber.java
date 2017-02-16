
public class ThirdMaximumNumber {

	//solution 1
	public static int thirdMax(int[] nums) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		for (Integer n : nums) {
		    if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
		    if (max1 == null || n > max1) {
		        max3 = max2;
		        max2 = max1;
		        max1 = n;
		    } else if (max2 == null || n > max2) {
		        max3 = max2;
		        max2 = n;
		    } else if (max3 == null || n > max3) {
		        max3 = n;
		    }
		}
		return max3 == null ? max1 : max3;
	}
	//solution 2
	public static int thirdMax2(int[] nums) {
        int max, mid, small;
		max = mid = small = Integer.MIN_VALUE;
		int flag = 0;
		for(int i = 0; i < nums.length; i++){
		    if (nums[i] == Integer.MIN_VALUE){
		        flag = 1;
		    }
			if(nums[i] > max){
				small = mid;
				mid = max;
				max = nums[i];

			}if(nums[i] < max && nums[i] > mid){
				small = mid;
				mid = nums[i];
			}
			
			if(nums[i] < mid && nums[i] > small){
				small = nums[i] ;
			}
		}

		if(mid == Integer.MIN_VALUE||small == Integer.MIN_VALUE && flag == 0){
			return max;
		}else{
		    return small;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,1,2,3,4,6,7,7};
		//Compare algorithm
		//solution 1
		long startTime = System.nanoTime();
		int max ;
    	max = thirdMax(nums1);
    	System.out.println(max);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	//solution 2
    	int[] nums2 = {1,1,2,3,4,6,7,7};
    	long startTime2 = System.nanoTime();
    	int max2;
    	max2 = thirdMax2(nums2);
    	System.out.println(max2);
    	long endTime2 = System.nanoTime();
    	System.out.println("Took "+(endTime2 - startTime2) + " ns"); 
	}
}
