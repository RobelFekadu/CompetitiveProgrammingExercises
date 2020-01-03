//https://leetcode.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        long temp = 5;
        
        while(n / temp > 0){
            count += n / temp;
            temp *= 5;
        }
        return count;
    }
}