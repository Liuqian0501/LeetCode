public class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    int size;
    double sum = 0;
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if(queue.size() > size){
            sum -= queue.poll();
        } 
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
