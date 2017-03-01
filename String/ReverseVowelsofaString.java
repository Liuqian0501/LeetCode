public class Solution {
    public String reverseVowels(String s) {
        if(s == null) return null;
        List<Integer> list = new ArrayList<>();//store vowels' index
        char[] newString = s.toCharArray();
        String v = "aeiouAEIOU";
        for(int i = 0; i < s.length(); i++){
            if(v.contains(s.charAt(i)+"")) list.add(i);
        }
        int head = 0, tail = list.size()-1;
        while(head <= tail){
            newString[list.get(tail)] = s.charAt(list.get(head));
            newString[list.get(head)] = s.charAt(list.get(tail));
            head++;
            tail--;
        }
        return new String(newString);
    }
}


public class Solution {
    public String reverseVowels(String s) {
        if(s == null) return null;
        List<Integer> list = new ArrayList<>();
        char[] newString = new char[s.length()];
        List<Character> v = new ArrayList<>();
        v.add('a');v.add('e');v.add('i');v.add('o');v.add('u');v.add('A');v.add('E');v.add('I');v.add('O');v.add('U');
        for(int i = 0; i < s.length(); i++){
            if(v.contains(s.charAt(i))) list.add(i);
            newString[i] = s.charAt(i);
        }
        int head = 0, tail = list.size()-1;
        while(head <= tail){
            newString[list.get(tail)] = s.charAt(list.get(head));
            newString[list.get(head)] = s.charAt(list.get(tail));
            head++;
            tail--;
        }
        return new String(newString);
    }
}
