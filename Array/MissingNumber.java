public class MissingNumber {
	public static int missingNumber(int[] nums) {
		int zeroFlag = 0;//whether zero in the array
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]==0) {
				zeroFlag = i+1;
			}else{
				nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
			}
		}

		if (zeroFlag==0) {
			//will return result = 0
		}else {
			for(int i = 0; i < nums.length; i++){
				if (nums[i]>0) {
					result =  i+1;
				}
				if (result==0) {
					result = zeroFlag;
				}
			}
			
		}
		return result;
    }
	public static void main(String args[]) {
		int[] str = {2,1};
    	long startTime = System.nanoTime();
    	int a = missingNumber(str);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime)+ " ns"); 
    	System.out.println(a);
	}
}
