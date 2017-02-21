package binarySearch;
/*
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

@auther Qian Liu
 */
public class FirstBadVersion {
	static int[] version = {0,0,0,0,0,1,1,1};
	public static int firstBadVersion(int n) {
		//base case
		if(isBadVersion(1) == true){
			return 1;
		}
		
		//binary search
		int head = 1, tail = n,mid;
		while(true){
			mid = head + (tail-head) / 2;
			if (isBadVersion(mid) == true) {
				if(isBadVersion(mid - 1) == false){
					return mid;
				}
				tail = mid;
			}else{
				head = mid+1;
			}
		}
    }
	
	private static boolean isBadVersion(int i) {
		// TODO Auto-generated method stub
		
		return version[i-1]==1;
	}
	public static void main(String[] args) {
		System.out.println(firstBadVersion(6));
	}
}
