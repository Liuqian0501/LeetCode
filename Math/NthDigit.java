public class Solution {
    public int findNthDigit(int n) {
        // we need to find which range n belongs to 1:(1-9),2:(10-99),3:(100,999)...
        int standard = 9, range = 1,num = 0;
        int temp = n;
        while(true){
            n = temp;
            temp = temp - standard * range;
            if(temp <= 0 || n < temp) break;
            num = num + standard;
            standard *= 10;
            range ++;
        }

        num = num + n/range;//the num that digit pos
       
        int index = n%range; //index from right of num
        
        if(index == 0){
            num = num%10;
        }else{
            String number = Integer.toString(num+1);
            num = Character.digit(number.charAt(index-1),10); // index from right of num+1
        }
        return num;
 
    }
}
