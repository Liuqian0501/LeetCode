//https://leetcode.com/problems/trapping-rain-water/#/description
public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if(len < 3) return 0;
        int left = 0;
        int right = len - 1;
        
        //find left and right to start with
        while(left < right && A[left + 1] > A[left]) left++;
        while(right > 0 && A[right - 1] > A[right]) right--;
        
        int ans = 0;
        while(right > left){
            int leftV = A[left], rightV = A[right];
            if(leftV < rightV){
                while(left < right && leftV >= A[++left])
                    ans += leftV - A[left];
            }else{
                while(right > left && rightV >= A[--right])
                    ans += rightV - A[right];
            } 
        }
        return ans;
        
    }
}
