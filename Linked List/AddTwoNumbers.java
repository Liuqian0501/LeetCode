/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int car = 0;
    int val;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // To solve this problem, we need a carrier and compare the length 
        ListNode newNode;
        if(l1 == null){
            if(l2 == null) {
                if(car == 0){
                    return null;
                }else{
                    return new ListNode(car);
                }
            }
            else {
                val = l2.val + car;
                car = val / 10;
                val -= 10*car;
                newNode = new ListNode(val);
                newNode.next = addTwoNumbers(null, l2.next);
            }
        }else{
            if(l2 == null){
                val = l1.val + car;
                car = val / 10;
                val -= 10*car;
                newNode = new ListNode(val);
                newNode.next = addTwoNumbers(l1.next, null);
            } 
            else{
                val = l1.val + l2.val + car;
                car = val / 10;
                val -= 10*car;
                newNode = new ListNode(val);
                newNode.next = addTwoNumbers(l1.next, l2.next);
            }
        }
        return newNode;
    }
}
