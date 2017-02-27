/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long end = (long) n;
        long start = 0;
        long mid = start + (end - start)/2;
        while(start <= end){
            if(guess((int) mid ) == 0){
                return (int) mid;
            }
            if(guess((int) mid ) == 1){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
            mid = start + (end - start)/2;
        }
        return 0;
    }
}
