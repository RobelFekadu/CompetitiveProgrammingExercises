import java.lang.Math.*;
public class PerfectNumber{
    public boolean checkPerfectNumber(int num) {
        if(num == 1)
            return false;
        int sqrtNum = (int)Math.sqrt(num);
        int sum = 1;

        for (int i = 2; i <= sqrtNum; i++) {
            if(num % i == 0){
                sum += i;
                sum += num / i;
            }
        }

        return num == sum;
    }
}