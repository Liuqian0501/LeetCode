/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //For God's sake, don't try sorting a linked list during the interview
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        head = new ListNode(0);
        ListNode head2 = head;
        for(int i : list){
            head.next = new ListNode(i);
            head = head.next;
        }
        return head2.next;
        
    }
    
}
