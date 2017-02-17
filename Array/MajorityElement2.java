import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @authur Qian Liu
 */


public class MajorityElement2 {
	
	//hashmap
	public static List<Integer> majorityElement(int[] nums) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i : nums) {
			hashMap.put(i, hashMap.getOrDefault(i, 0)+1);
			if (hashMap.get(i)>nums.length/3 && !list.contains(i)) {
				list.add(i);
				if (list.size()==2) {
					break;
				}
			}
		}
	    return list;
	}
	
	//Boyer-Moore Majority Vote algorithm
	public static List<Integer> majorityElement2(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
			else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i : nums) {
			if (i == number1)
				count1++;
			else if (i == number2)
				count2++;
		}
		if (count1 > len / 3)
			result.add(number1);
		if (count2 > len / 3)
			result.add(number2);
		return result;
	    
	}
	public static void main(String args[]) {
		int[] str = {1,1,1,1,1,2,2,2,2,2,3,3,4,5};
    	long startTime = System.nanoTime();
    	List<Integer> a = majorityElement(str);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	for(int b : a){
    		System.out.print(b+" ");
    	}
    	
	}
}
