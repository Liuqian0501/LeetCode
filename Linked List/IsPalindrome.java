package linkedListCycle;
/*
 * Given a singly linked list, determine if it is a palindrome.
 * @auther Qian Liu
 */

public class IsPalindrome {
	static ListNode aListNode = new ListNode(1);
	static ListNode bListNode = new ListNode(3);
	static ListNode cListNode = new ListNode(3);
	static ListNode dListNode = new ListNode(1);

	public static boolean isPalindrome(ListNode head) {
		boolean flag = true;
		
		// base case
		if (head == null || head.next == null) {
			return flag;
		}
		
		// find middle-end and middle-head
		ListNode middleEnd = head, end = head, middleHead = head;
		while(end != null ) {
			middleEnd = middleEnd.next;
			if(end.next == null){
				middleHead = middleHead.next;
				break;
			}else {
				end = end.next.next;
				middleHead = middleEnd;
			}
		}
		
		
		// reverse end point to middle point
		ListNode nextHead = middleHead, newHead = null;
		middleHead = null;
		while(nextHead != null){
			newHead = nextHead;
			nextHead = nextHead.next;
			newHead.next = middleHead;
			middleHead = newHead;
			
		}
		
		//compare head to middel with middle to end
		while(middleHead != null){
			if (middleHead.val == head.val) {
				middleHead = middleHead.next;
				head = head.next;
			}else{
				flag = false;
				break;
			}
		}
		return flag;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aListNode.next = bListNode;
		bListNode.next = cListNode;
		cListNode.next = dListNode;
		dListNode.next = null;
		System.out.println(isPalindrome(dListNode));

	}

}
