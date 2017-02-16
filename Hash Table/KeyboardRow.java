package hashTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class KeyboardRow {
    public static String[] findWords(String[] words) {
    	HashMap<Character, Integer> keyboardRoll = new HashMap<>();
    	List<String> outList = new ArrayList<>();
    	Character[] roll1 = {'q','w','e','r','t','y','u','i','o','p'},
    				roll2 = {'a','s','d','f','g','h','j','k','l'},
    				roll3 = {'z','x','c','v','b','n','m'};
    	for(Character a: roll1){
    		keyboardRoll.put(a, 1);
    		keyboardRoll.put(Character.toUpperCase(a),1);
    	}
    	for(Character b: roll2) {
    		keyboardRoll.put(b, 2);
    		keyboardRoll.put(Character.toUpperCase(b),2);
    	}
    	for(Character c: roll3) {
    		keyboardRoll.put(c, 3);
    		keyboardRoll.put(Character.toUpperCase(c),3);
    	}
    	for(String str: words){
    		int hashvalue = keyboardRoll.get(str.charAt(0));
    		int flag = 0; //  whether all chars are the same
    		for(int i = 0; i < str.length(); i++) {
    			if(keyboardRoll.get(str.charAt(i))!=hashvalue){
    				flag = 1;
    				break;
    			}
    		}
    		if (flag == 0) outList.add(str);
    	}
    	
    	String[] outArr = new String[outList.size()];
    	outArr = outList.toArray(outArr);

        return outArr;
    }
	public static void main(String args[]) {
		String[] str = {"Hello", "Alaska", "Dad", "Peace"};
    	long startTime = System.nanoTime();
    	String[] a = findWords(str);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	//for(String s : a)
    	    //System.out.println(s);
    	//System.out.println(a.toString());
	}
}
