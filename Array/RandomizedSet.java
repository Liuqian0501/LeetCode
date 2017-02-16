import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 * @author Qian Liu
 */
public class RandomizedSet {

	/** Initialize your data structure here. */
	List<Integer> set;
    public RandomizedSet() {
        set = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if (set.contains(val)) {
			return false;
		}else {
			set.add(val);
			return true;
		}
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if (set.contains(val)) {
			set.remove(set.indexOf(val));
    		return true;
		}else {
			return false;
		}
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random rand = new Random(); 
    	int value = rand.nextInt(set.size());
		return set.get(value);
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val = 1;
		RandomizedSet obj = new RandomizedSet();
		
		long startTime = System.nanoTime();
		boolean param_1 = obj.insert(val);
		boolean param_2 = obj.remove(val);
		int param_3 = obj.getRandom();
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	
	}
}

