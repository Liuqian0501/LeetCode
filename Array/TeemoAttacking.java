public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length==0){
            return 0;
        }
        int totalTime = 0;
        int start = timeSeries[0];
        int end = start+duration;
        for(int i: timeSeries){
            if (i< end){
                totalTime = totalTime+(i-start);
            }else{
                totalTime = totalTime+duration;
            }
            start = i;
            end = start+duration;
        }
        totalTime = totalTime+duration;
        return totalTime;
    }
    
    
}
