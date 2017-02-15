
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		int[] nums = {1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1};
		//Compare algorithm

		//method 1
		long startTime = System.nanoTime();
		int max = 0;
		for ( int i=0;i<100;i++) {
			max = findMaxConsecutiveOnes(nums);
		}
		System.out.println(max);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 

		//method 2
		long startTime2 = System.nanoTime();
		for ( int i=0;i<100;i++) {
			max = findMaxConsecutiveOnes2(nums);
		}
		System.out.println(max);
		long endTime2 = System.nanoTime();
		System.out.println("2 Took "+(endTime2 - startTime2) + " ns"); 
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int cons = 0;
		int maxCons = 0;
		for(int i:nums){
			if (i==1) {
				cons++;
				//maxCons = maxCons >= cons ? maxCons : cons; //slower
				if(maxCons<cons){
					maxCons = cons;
				}
			}else{
				cons = 0;
			}
		}
		return maxCons;
	}
	
    	public static int findMaxConsecutiveOnes2(int[] nums) {
		int cons = 0;
		int maxCons = 0;
		for(int i:nums){
			if (i==1) {
				cons++;

				if(maxCons<cons){
					maxCons = cons;
				}
			}else{
				cons = 0;
			}
        	}
        	return maxCons;
    	}
}
