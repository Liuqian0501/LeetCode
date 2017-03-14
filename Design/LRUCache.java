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
