package string;
/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * @auther Qian Liu
 */

public class ValidPalindrome{

	public static boolean isPalindrome(String s) {

		int end = s.length()-1, start = 0 ;
		
		//two points
		while(end > start){
			char head = s.charAt(start), tail = s.charAt(end);
			if(!Character.isLetterOrDigit(head)) {
				start++;
			}else if(!Character.isLetterOrDigit(tail)){
				end--;
			}else if(Character.toLowerCase(head) == Character.toLowerCase(tail)){
				start++;
				end--;
			}else{
				System.out.println(head+" "+ tail);
				return false;
			}
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPalindrome("a.A"));

	}

}
