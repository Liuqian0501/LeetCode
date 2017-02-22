/**
 * 
 */
package hashTable;

import java.util.HashMap;

/**
 * @author LiuQianKevin
 *
 */
public class FourSumII {

	/**
	 * @param args
	 */
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		
		// devide and counquer
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int res = 0;
		int sum;
		for(int i = 0; i < A.length; i++){
			for (int j = 0; j < B.length; j++) {
				sum = A[i]+B[j];
				hashMap.put(sum, hashMap.getOrDefault(sum, 0)+1);
			}
		}
		
		for(int i = 0; i < C.length; i++){
			for (int j = 0; j < D.length; j++) {
				sum = -D[i]-C[j];
				res += hashMap.getOrDefault(sum, 0);
			}
		}
		return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2};
		int[] B = {0,0};
		int[] C = {1,-1};
		int[] D = {0,1};
		System.out.println(fourSumCount(A,B,C,D) );
 	}

}
