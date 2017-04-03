//https://leetcode.com/problems/intersection-of-two-arrays/#/description
public class Solution {
    //similar algorithm as in merge sort
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 == 0 || len2 == 0) return new int[0];
        //sort two arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //compare the element at heated of the array
        int head1 = 0, head2 = 0, index = 0;
        while(head1 < len1 && head2 < len2){
            if(nums1[head1] == nums2[head2]){//write the value to num1[index]
                    nums1[index] = nums1[head1];
                    head1++;
                    head2++;
                    while(head1 < len1 && nums1[head1] == nums1[index]) head1++;//skip same value
                    while(head2 < len2 && nums2[head2] == nums1[index]) head2++;
                    index++;
            }else if(nums1[head1] < nums2[head2]){
                head1++;
                while(head1 < len1 && nums1[head1] == nums1[head1 - 1]) head1++;
            }else{
                head2++;
                while(head2 < len2 && nums2[head2] == nums2[head2 - 1]) head2++;
            }
        }
        int[] res = new int[index];
        for(int i = 0; i < index; i++){
            res[i] = nums1[i];
        }
        return res;
    }
}
