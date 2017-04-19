public class Solution {
    // helper linked list class
    private class Node{
        int val;
        Node next;
        private Node(int val){
            this.val = val;
        }
    }
    int len;
    Node head;
    public int[] nextGreaterElements(int[] nums) {
        len = nums.length;
        if(len == 0) return nums;
        storeData(nums);

        for(int i = 0; i < len; i++){
            nums[i] = findNextGreater(head);
            head = head.next;
        }
        return nums;
    }
    /**
     * store data in linkedlist as a loopstack
     * 
     * @param nums the input data
     */ 
    public void storeData(int[] nums){
        Node first = new Node(nums[0]);
        head = first;
        for(int i = 1; i < nums.length; i++){
            first.next = new Node(nums[i]);
            first = first.next;
        }
        first.next = head;
    }
    
    /**
     * find the next greater element of x in stack
     * 
     * @param temp item we work on
     */
    public int findNextGreater(Node temp){
        int val = temp.val;
        for(int i = 1; i <= len; i++){
            if(temp.val > val) return temp.val; 
            temp = temp.next;
        }
        return -1;
    }
}
