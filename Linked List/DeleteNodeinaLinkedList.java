package linkedListCycle;

public class DeleteNodeinaLinkedList {

	public static boolean hasCycle(ListNode head) {
        if(head == null) return false;
    	ListNode walk = head;
    	ListNode run = head;
    	while(run.next != null && run.next.next != null){
    		run = run.next.next;
    		walk = walk.next;
    		if(walk==run){
    			return true;
    		}
    	}
        return false;       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode aListNode = new ListNode(1);
		ListNode bListNode = new ListNode(2);
		ListNode cListNode = new ListNode(3);
		ListNode dListNode = new ListNode(4);
		aListNode.next = bListNode;
		bListNode.next = cListNode;
		cListNode.next = dListNode;
		dListNode.next = aListNode;
		System.out.println(hasCycle(aListNode));

	}

}
