https://leetcode.com/problems/largest-number/#/description
public class Solution {
    //sort the first figure
    public String largestNumber(int[] nums) {
        int len = nums.length;
        if(len==0) return "0";
        String[] str = new String[len];
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> cmp = new Comparator<String>(){
            @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
    			String s2 = str2 + str1;
    			return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }
        };
        Arrays.sort(str, cmp);
        if(str[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
		for(String s: str)
	            sb.append(s);
		
		return sb.toString();
    }
}
