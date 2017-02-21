package math;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @auther Qian Liu
 */

public class IsPalindrome{

	public static boolean isPalindrome(int x) {
        // reverse the integer
		if (x<0) {
			return false;
		}
		int rev = 0;
		int xCopy = x;
		while(xCopy > 9 ){
			rev = rev*10 + xCopy%10;
			xCopy /= 10;
		}
		rev = rev*10 + xCopy;
		return x==rev;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPalindrome(-2147483648));

	}

}
