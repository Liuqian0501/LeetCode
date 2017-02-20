package linkedListCycle;


public class DeleteDuplicates {
	static ListNode aListNode = new ListNode(1);
	static ListNode bListNode = new ListNode(2);
	static ListNode cListNode = new ListNode(2);
	static ListNode dListNode = new ListNode(4);

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		// recursive if head.next.val = head.val, head.next = head.next.next
		System.out.println(head.val);
    	head.next = deleteDuplicates(head.next);
        return head.next.val == head.val ? head.next : head;       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aListNode.next = bListNode;
		bListNode.next = cListNode;
		cListNode.next = dListNode;
		dListNode.next = aListNode;
		deleteDuplicates(aListNode);

	}

}
