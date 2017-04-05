/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//https://leetcode.com/problems/merge-intervals/#/description
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // sort start&end
    	int n = intervals.size();
    	int[] starts = new int[n];
    	int[] ends = new int[n];
    	for (int i = 0; i < n; i++) {
    		starts[i] = intervals.get(i).start; // start[i] 对应的是第i段的开头
    		ends[i] = intervals.get(i).end;//ends[i]对应的是第i段的结尾
            //这样处理后得到的interval和之前的是一致的。
    	}
    	Arrays.sort(starts);
    	Arrays.sort(ends);
    	// loop through
    	List<Interval> res = new ArrayList<Interval>();
    	for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
    		if (i == n - 1 || starts[i + 1] > ends[i]) {
    			res.add(new Interval(starts[j], ends[i]));
    			j = i + 1;
    		}
    	}
    	return res;
    }
}
