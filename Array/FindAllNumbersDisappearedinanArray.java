import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FindAllNumbersDisappearedinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,3,3,3,6,8};
    	//Compare algorithm
		//method 1
		long startTime = System.nanoTime();
		List<Integer> max = null;
    	max = findDisappearedNumbers(nums);
    	System.out.println(max);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	//method 2
    	long startTime2 = System.nanoTime();
    	max = findDisappearedNumbers2(nums);
    	System.out.println(max);
    	long endTime2 = System.nanoTime();
    	System.out.println("2 Took "+(endTime2 - startTime2) + " ns"); 
	}

    public static List<Integer> findDisappearedNumbers(int[] nums) {
    	//List<Integer> range = IntStream.range(1, nums.length+1).boxed().collect(Collectors.toList());
    	List<Integer> range = new ArrayList<>();
    	for(int i=0;i<nums.length; i++){
    		range.add(i+1);
    	}
    	for(int i=0;i<range.size();i++){
    		System.out.print(range.get(i)+" ");
    	}
    	for(int i: nums){
    		range.set(i-1, null);
    		//System.out.print(i);
    	}
    	range.removeIf(Objects::isNull);
    	System.out.print(range.size()+" ");
    	for(int i=0;i<range.size();i++){
    		System.out.print(range.get(i)+" ");
    	}
    	//System.out.print("sdsd"+count.length);
		return null;
        
    }
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
    	List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
        for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
        return res;
    }
    
    public static List<Integer> findDisappearedNumbers3(int[] nums) {
    	List<Integer> result = new ArrayList<Integer>();
        for( int i=0;i< nums.length; i++){
            int index = nums[i];
            if(nums[Math.abs(index)-1] > 0){
                nums[Math.abs(index)-1]= -nums[Math.abs(index)-1];
            }
        }
        
        for(int j  :nums){
            if(j > 0){
                result.add(j);
            }
        }
        return result;
    }
}
