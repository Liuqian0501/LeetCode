import java.util.ArrayList;
import java.util.List;



public class FindAllDuplicatesinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,1,2,3,4,6,7,7};
    	//Compare algorithm
		//method 1
		long startTime = System.nanoTime();
		List<Integer> max = null;
    	max = findDisappearedNumbers(nums1);
    	System.out.println(max);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	//method 2
    	int[] nums2 = {1,1,2,3,4,6,7,7};
    	long startTime2 = System.nanoTime();
    	max = findDisappearedNumbers2(nums2);
    	System.out.println(max);
    	long endTime2 = System.nanoTime();
    	System.out.println("Took "+(endTime2 - startTime2) + " ns"); 
	}

    public static List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++) nums[((nums[i]-1) % n)] += n;
        for (int i = 0; i < nums.length; i ++) if ((nums[i] - 2*n) > 0) res.add(i+1);

        return res;
    }
    
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
    	List<Integer> result = new ArrayList<Integer>();
        for( int i=0;i< nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0){
            	nums[index]= -nums[index];
            }else{
            	result.add(index+1);
            }
        }
        return result;
    }
}
