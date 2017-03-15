//solution 1

public class LRUCache {
    // once the key is used, set the key to the top of a list
    // I am going to implement a bouble linked list
    Map<Integer, Node> cacheMap;
    int capacity;
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
    }
    public int get(int key) {
        if(this.cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            deleteNode(node);
            headNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.cacheMap.containsKey(key)){  // update node 
                Node node = this.cacheMap.get(key);
                node.val = value;
                deleteNode(node);
                headNode(node);
        }else{          // add node
                if(this.capacity == this.cacheMap.size()){ // delete before add
                    deleteNode(tail);
                }
                headNode(new Node(value, key));
        }
    }
    private void deleteNode(Node node){
        this.cacheMap.remove(node.key);
        if(node.prev == null || node.next == null){
            if(node.prev == null){ //update new head
                this.head = node.next;
            }
            if(node.next == null){// update new tail
                this.tail = this.tail.prev;
                if(this.tail != null) this.tail.next = null;
            }
            node = null;
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    private void headNode(Node node){
        node.next = this.head;
        node.prev = null;
        if(this.cacheMap.size() == 0){
            this.head = node;
            this.tail = node;
        }else{
            this.head.prev = node;
        }
        this.head = node;

        if(this.cacheMap.size() == 1){
            this.tail.prev = node;
        }
        this.cacheMap.put(node.key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Node{
    Node prev;
    Node next;
    int val;
    int key;
    public Node(int c, int d){
        this.prev = null;
        this.next = null;
        this.val = c;
        this.key = d;
    }
}


public class LRUCache {
    // once the key is used, set the key to the top of a list
    // I am going to implement a hashtable to store the index information of the key and the corespoinding value;
    Map<Integer, Integer> cacheMap;
    List<Integer> index;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>(capacity);
        this.index = new ArrayList<>(capacity);
    }
    
    public int get(int key) {
        if(this.index.indexOf(key) != -1){
            this.index.remove(this.index.indexOf(key));
            this.index.add(0,key);
            return this.cacheMap.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(index.indexOf(key) == -1){ // if full, remove invalidate
            if(this.capacity == index.size()){
                this.cacheMap.remove(index.get(index.size()-1));
                this.index.remove(index.size()-1);
            }
        }else{
            this.index.remove(this.index.indexOf(key));
        }
        this.index.add(0,key);
        this.cacheMap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
