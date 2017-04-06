public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return dfs(input, new HashMap<String, List<Integer>>());
    }
    private List<Integer> dfs(String s, HashMap<String, List<Integer>> map){
        if(map.containsKey(s))
            return map.get(s);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            if(curChar == '+'||curChar == '-'||curChar=='*'){
                String leftStr = s.substring(0,i);
                String rightStr = s.substring(i+1);
                List<Integer> leftList = dfs(leftStr, map);
                List<Integer> rightList = dfs(rightStr, map);
                for(int le : leftList){
                    for(int ri : rightList){
                        switch(curChar){
                            case '*':
                                    list.add(le*ri);
                                    break;
                            case '+':
                                    list.add(le+ri);
                                    break;
                            case '-':
                                    list.add(le-ri);
                                    break;
                        }
                    }
                }
            }
        }
        if(list.size() == 0){
            list.add(Integer.valueOf(s));
        }
        map.put(s,list);
        return list;
    }
}
