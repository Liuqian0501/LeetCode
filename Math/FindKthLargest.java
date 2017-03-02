public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int maxIndex;
        for(int i = 0; i < k; i++){
            //bubble
            maxIndex = bubble(nums,i);
            swap(nums,i,maxIndex);
        }
        return nums[k-1];

    }
    public void swap(int[] nums, int i, int maxIndex){
        int temp = nums[i];
        nums[i] = nums[maxIndex];
        nums[maxIndex] = temp;
    }
    public int bubble(int[] nums, int i){
        int maxIndex = i;
        for(int j = i; j < nums.length; j++){
           if(nums[maxIndex] < nums[j]){
               maxIndex = j;
           }
        }
        return maxIndex;
    }
}


//solution 2
public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
}
