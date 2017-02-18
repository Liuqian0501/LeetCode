package hashTable;

import java.util.ArrayList;
import java.util.List;


public class FindAllAnagramsinaString {
	
	//renew characterHash table
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;
		for (int i = 0; i <= (s.length() - p.length()); i++) {
			int count = p.length();
			int[] characterHash = new int[256];
			for(char a : p.toCharArray()){
				characterHash[a]++;
			}
			for(int j = i; j < i + p.length(); j++){
				if(characterHash[s.charAt(j)]-- > 0){
					//characterHash[s.charAt(j)]--;
					count--;
					//System.out.println(s.charAt(j)+" "+count);
					if (count==0) {
						result.add(i);
					}
				}else{
					break;
				}
			}
		}
        return result;
    }
	//one characterHash table
		public static List<Integer> findAnagrams2(String s, String p) {
			List<Integer> result = new ArrayList<>();
			if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;
			int left = 0,right = 0,count = p.length();
			int[] characterHash = new int[256];
			for(char a : p.toCharArray()){
				characterHash[a]++;
			}
			while(right < s.length()){
				if(characterHash[s.charAt(right++)]-- >=1){
					count--;
					System.out.println("right add"+ left);
					for(char m : s.toCharArray()){
						System.out.print(characterHash[m]);
					}	
					System.out.println();
					//System.out.println(count+ " "+s.charAt(left));
					//System.out.println(count +" ");
				}
				if(count==0) result.add(left);
				if(right - left == p.length() && characterHash[s.charAt(left++)]++ >=0){
					count++;
					System.out.println("left add"+ right);
					for(char m : s.toCharArray()){
						System.out.print(characterHash[m]);
					}	
					System.out.println();
					
				}
				//System.out.println(right+" "+ count);
				//System.out.println(characterHash[s.charAt(right)]);
			}
	        return result;
	    }
	
	
	public static void main(String args[]) {
		String str = "cbaebabacd";
		String str2 = "abc";
    	long startTime = System.nanoTime();
		List<Integer> a = findAnagrams2(str,str2);
    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    	for(int m : a){
    		System.out.print(m+ " ");
    	}
    	//System.out.println(a.toString());
	}
}
