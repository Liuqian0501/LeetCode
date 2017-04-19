public class Solution {
    // helper linked list class
    private class Node{
        int val;
        Node next;
        private Node(int val){
            this.val = val;
        }
    }
    
    /**
     * test method, find all the next greater numbers for nums1's elements in the corresponding places of nums2.
     * 
     * @param findNums nums1
     * @param nums nums2
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if(findNums.length == 0) return findNums;
        
        Map<Integer, Node> hashMap = new HashMap<>();
        
        storeData(hashMap, nums);

        for(int i = 0; i < findNums.length; i++){
            findNums[i] = findNextGreater(hashMap, findNums[i]);
        }
        return findNums;
    }
    
    /**
     * store data in hashmap and in linkedlist as a stack
     * 
     * @param hashMap the hashMap used to store data
     * @param nums the input data
     */ 
    public void storeData(Map<Integer, Node> hashMap, int[] nums){
        Node first = new Node(nums[0]);
        hashMap.put(nums[0],first);
        for(int i = 1; i < nums.length; i++){
            first.next = new Node(nums[i]);
            first = first.next;
            hashMap.put(nums[i],first);
        }
    }
    
    /**
     * find the next greater element of x in stack
     * 
     * @param hashMap the hashMap used to store data
     * @param x item we work on
     */
    public int findNextGreater(Map<Integer, Node> hashMap, int x){
        Node temp = hashMap.get(x).next;
        while(temp != null && temp.val <= x){
            temp = temp.next;
        }
        return (temp == null) ? -1:temp.val;
    }
}
