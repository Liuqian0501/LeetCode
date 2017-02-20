package linkedListCycle;
/*
 * Remove all elements from a linked list of integers that have value val.
 * @auther Qian Liu
 */

public class RemoveElements {
	static ListNode aListNode = new ListNode(1);
	static ListNode bListNode = new ListNode(2);
	static ListNode cListNode = new ListNode(2);
	static ListNode dListNode = new ListNode(4);

	public static ListNode removeElements(ListNode head, int val) {
		if(head == null ) return null;
		// recursive if head.next.val = head.val, head.next = head.next.next
    	head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aListNode.next = bListNode;
		bListNode.next = cListNode;
		cListNode.next = dListNode;
		dListNode.next = aListNode;
		removeElements(aListNode,1);

	}

}
