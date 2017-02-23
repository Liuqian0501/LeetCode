/**
 * 
 */
package linkedListCycle;

/**
 * @author LiuQianKevin
 *
 */
public class RotateList {

	/**
	 * @param args
	 */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null||k==0) return head;
        
        //find the total length
    	int i = 1;
    	ListNode oldHead = head, result = null;
        while(head.next != null){
        	i++;
        	head = head.next;
        }

        head.next = oldHead; // connext tail and head
        
        // pos to rotate
        k = k % i;

        
        // find the cut point
        for(int m = 0; m < i-k-1; m++){
            oldHead = oldHead.next;
        }
        
        result = oldHead.next;// new head
        oldHead.next = null;// cut the list
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
