import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 * @author Qian Liu
 */
public class RandomizedCollection {

	/** Initialize your data structure here. */
	List<Integer> Collection;
    public RandomizedCollection() {
    	Collection = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

    		Collection.add(val);
			return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if (Collection.contains(val)) {
    		Collection.remove(Collection.indexOf(val));
    		return true;
		}else {
			return false;
		}
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random rand = new Random(); 
    	int value = rand.nextInt(Collection.size());
		return Collection.get(value);
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val = 1;
		RandomizedCollection obj = new RandomizedCollection();
		
		long startTime = System.nanoTime();
		boolean param_1 = obj.insert(val);
		boolean param_4 = obj.insert(val);
		boolean param_2 = obj.remove(val);
		int param_3 = obj.getRandom();
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	
	}
}

