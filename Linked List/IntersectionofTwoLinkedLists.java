package linkedListCycle;

import java.util.HashMap;
import java.util.Map;

public class IntersectionofTwoLinkedLists {
	static ListNode aListNode = new ListNode(1);
	static ListNode bListNode = new ListNode(2);
	static ListNode cListNode = new ListNode(3);
	static ListNode dListNode = new ListNode(4);
	
	/*
	 * space O(n), speed O(n)
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Map<ListNode, Integer> hashMapA = new HashMap<>();
		Map<ListNode, Integer> hashMapB = new HashMap<>();
		if (headA == null || headB == null) {
			return null;
		}
		while (headA != null || headB != null) {
			if (headA !=null){
				if (hashMapB.containsKey(headA)) {
						return headA;
				}else{
					hashMapA.put(headA, 1);
					headA = headA.next;
				}

			}
			if (headB !=null){
				if (hashMapA.containsKey(headB)) {
					return headB;
				}else{
					hashMapB.put(headB, 2);
					headB = headB.next;
				}
			}
		}
		return null;
    }
	/*
	 * conpare same index from the end.
	 * Space O(1) Speed O(n)
	 */
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		
		if (headA ==null || headB == null) {
			return null;
		}
		int lengthA = length(headA);
		int lengthB = length(headB);
		
		while(lengthA != lengthB){
			if (lengthA > lengthB) {
				lengthA--;
				headA = headA.next;
			}else {
				lengthB--;
				headB = headB.next;
			}
		}
		
		while (headA !=  headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
    }
	private static int length(ListNode head) {
		int length = 1;
		while (head.next != null) {
			head = head.next;
			length++ ;
			
		}
		return length;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		aListNode.next = bListNode;
		bListNode.next = cListNode;
		cListNode.next = dListNode;
		dListNode.next = aListNode;
		
		getIntersectionNode(aListNode, bListNode);

	}

}
