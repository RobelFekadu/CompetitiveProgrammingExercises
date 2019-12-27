public class ReverseInteger{
    public static void main(String[] args) {
        System.out.println(reverse(900));
        System.out.println(reverse(7084));
    }

    static int reverse(int num) {
        int finalNum = 0;
        while (num != 0) {
            long temp = finalNum;
            int rem = num % 10;
            num /= 10;
            if(temp * 10 + rem > Integer.MAX_VALUE || temp * 10 + rem < Integer.MIN_VALUE)
                return 0;
            finalNum = finalNum * 10 + rem;
        }
        return finalNum;
    }
}