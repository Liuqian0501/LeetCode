/*
 * 	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * @auther Qian Liu
 */
public class MergeSortedArray {
	public static void merge(int[] A, int m, int[] B, int n) {
		//fill from the end of A, stop when there is no item in B, fill rest of B when A's items all used
		while(n>0) A[m+n-1] = (m==0||B[n-1] > A[m-1]) ? B[--n] : A[--m];
		for(int a : A){
			System.out.println(a);
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,0,0,0};
		int[] nums2 = {1,3};
		merge(nums1,2, nums2, 2);
	}

}
