package linkedListCycle;

public class MergeTwoSortedLists {
	static ListNode aListNode = new ListNode(1);
	static ListNode bListNode = new ListNode(2);
	static ListNode cListNode = new ListNode(3);
	static ListNode dListNode = new ListNode(4);

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		

		if(l1 == null) {
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		
		if(l1.val <= l2.val ){
			l1.next = mergeTwoLists(l1.next, l2);
			System.out.print(l1.val + " ");
			return l1;
		}else{
			l2.next = mergeTwoLists(l1, l2.next);
			System.out.print(l2.val + " ");
			return l2;
		}
  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aListNode.next = bListNode;
		bListNode.next = cListNode;
		cListNode.next = null;
		dListNode.next = null;
		
		mergeTwoLists(dListNode,cListNode);
		/*
		ListNode m = aListNode;
		while(m.next!=null){
			System.out.print(aListNode.val + " ");
			m = m.next;
		}
		*/

	}
}
