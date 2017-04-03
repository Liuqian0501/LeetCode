https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        		// search index from head and tail
		int head = 0, tail = numbers.length-1;
		int[] res = {0,0};
		while(head < tail){
			if(numbers[head] + numbers[tail] < target){
				head ++;
			}else if( numbers[head] + numbers[tail] > target){
				tail --;
			}else{
				res[0] = head+1;
				res[1] = tail+1;
				return res;
			}
		}
		return null;
    }
}
