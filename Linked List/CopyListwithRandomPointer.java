/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        
        //map old node to new node;
        Map<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        
        // store all linked node and edge in new linked list
        RandomListNode origHead = head;
        while(origHead != null){
            hashMap.put(origHead,new RandomListNode(origHead.label));
            origHead = origHead.next;
        }

        // linked new linked list
        origHead = head;
        while(origHead != null){
            hashMap.get(origHead).next = hashMap.get(origHead.next);
            hashMap.get(origHead).random = hashMap.get(origHead.random);
            origHead = origHead.next;
        }

        return hashMap.get(head);
    }
}
