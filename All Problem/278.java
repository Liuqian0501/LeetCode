/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//https://leetcode.com/problems/first-bad-version/#/description
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
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
				tail = mid-1;
			}else{
				head = mid+1;
			}
		}
    }
}
