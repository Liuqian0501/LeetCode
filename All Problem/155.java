class MinStack {
    private Node first;//top of stack
    
    // helper linked list class
    private class Node{
        private int val;
        private Node next;
        private int min;
    }
    
    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(int x) {
        Node oldFirst = first;
        first = new Node();
        first.val = x;
        if(oldFirst == null){
            first.min = x;
        }
        else{
            first.min = (x < oldFirst.min) ? x : oldFirst.min;
        }
        first.next = oldFirst;
    }
    
    /**
     *Remove item from stack
     */
    public void pop() {
        first = first.next;
    }
    
    /**
     * peek the first value of stack
     * 
     */
    public int top() {
        return first.val;
    }
    /**
     * get the minimum value of the stack
     */
    public int getMin() {
        return first.min;
    }
}
