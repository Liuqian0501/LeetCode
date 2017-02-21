package linkedListCycle;

import java.util.ArrayList;
import java.util.List;

/*
 * Remove all elements from a linked list of integers that have value val.
 * @auther Qian Liu
 */

public class ReverseList {
	static ListNode aListNode = new ListNode(1);
	static ListNode bListNode = new ListNode(2);
	static ListNode cListNode = new ListNode(2);
	static ListNode dListNode = new ListNode(4);

	static List<Integer> list = new ArrayList<>();
	static ListNode newNode = null;
	public static ListNode reverseList(ListNode head) {
        ListNode nextHead = head;
		ListNode newHead = null;
		head = null;
		while(nextHead != null){
			newHead = nextHead;
			nextHead = newHead.next;
			newHead.next = head;
			head = newHead;
		}
		return newHead;
    }
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aListNode.next = bListNode;
		bListNode.next = cListNode;
		cListNode.next = dListNode;
		dListNode.next = aListNode;
		reverseList(aListNode);

	}

}
