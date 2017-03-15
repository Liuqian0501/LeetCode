public class LFUCache {
    int capacity;
    Map<Integer, Node> hm1;
    Map<Integer, Node> hm2;
    Node tail;
    Node head;
    public LFUCache(int capacity) {
        hm1 = new HashMap<>();// key -> node
        hm2 = new HashMap<>();// freq -> head at freq
        tail = new Node(0,0,0);// default freq of tail is 0
        head = new Node(0,0,10000); //default freq of head is 10000;
        tail.next = null;
        tail.prev = head;
        head.next = tail;
        head.prev = null;
        hm2.put(0, tail);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        //System.out.println("get " + key);
        if(!hm1.containsKey(key)) return -1;
        Node node = hm1.get(key);
        int val = node.value;
        node.freq++;
        deleteNode(node);
        insert(node);
        return val;
    }
    
    public void put(int key, int value) {
        //System.out.println("put " + key);
        if(capacity == 0) return;
        if(hm1.containsKey(key)){//if hm1 contains key
            Node node = hm1.get(key);
            node.value = value;
            node.freq++;
            deleteNode(node);
            insert(node);
        }else{
            if(capacity == hm1.size()){
                deleteNode(tail.prev);
            }
            Node node1 = new Node(key, value, 1);
            insert(node1);
        }
    }
    public void deleteNode(Node node){
        //System.out.println("Delete " + node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        hm1.remove(node.key);
    }
    public void insert(Node node){// modify the position of key
        //search the hm2 hashtable to see the head for node.freq-1
        //System.out.println("Insert " + node.key);
        hm1.put(node.key,node);
        Node freqHead = hm2.get(node.freq-1);
        if(freqHead.key == node.key){//if node is freqHead
            if(node.freq < node.prev.freq){//no need to change position if node.prev.freq > node.freq
                
            }else{      //set node to be the head at node.freq, insert node before the head at freq
                Node freqHead2 = hm2.get(node.freq);
                add(node,freqHead2);
            }
            hm2.remove(node.freq);
            hm2.put(node.next.freq, node.next);
        }else{//if node is invalidate than freqHead
            if(freqHead.prev.freq > node.freq){//move node abead of freqHead if freqHead.prev.fret > node.freq
                add(node, freqHead);
            }else{
                Node freqHead3 = hm2.get(node.freq);
                add(node,freqHead3);
            }
        }
        hm2.put(node.freq, node);
        //System.out.println(node.key + " inserted ");
    }
    public void add(Node node1, Node node2){
        node2.prev.next = node1;
        node1.next = node2;
        node1.prev = node2.prev;
        node2.prev = node1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 class Node{
     int key;
     int value;
     int freq;
     Node prev;
     Node next;
     public Node(int key, int value, int freq){
         this.key = key;
         this.value = value;
         this.freq = freq;
     }
 }
