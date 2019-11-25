import java.util.*;

public class MathOperationsOnHugeNumbers{

    public static void main(String[] args) {
        System.out.println(sum("123123123159", "5923423423432"));
        System.out.println(sumWithNegative("102342342348", "-24345345345"));
        System.out.println(Multiply("10000002233", "1234567676767"));
    }
    private static String sum(String one, String two){
        int lengthForOne = one.length() - 1;
        int lengthForTwo = two.length() - 1;
        int rem = 0;
        String fSum = "";

        int min = lengthForOne > lengthForTwo ? lengthForTwo: lengthForOne;

        for(int i = 0; i <= min; i++){
            if(lengthForOne > -1 && lengthForTwo > -1){
                int sum = Character.getNumericValue(one.charAt(lengthForOne)) + Character.getNumericValue(two.charAt(lengthForTwo)) + rem;
                rem = 0;
                if(sum >= 10){
                    rem = 1;
                    sum -= 10;
                }
                fSum += sum;
                lengthForOne--;
                lengthForTwo--;
            }
            else
                break;
        }

        if(lengthForOne <= -1){
            for(int i = lengthForTwo; i >= 0; i--){
                fSum = fSum + (Character.getNumericValue(two.charAt(i)) + rem);
                rem = 0;
            }
        }
        else {
            for(int i = lengthForOne; i >= 0; i--){
                fSum = fSum + (Character.getNumericValue(one.charAt(i)) + rem) ;
                rem = 0;
            }
        }

        if(rem == 1)
            fSum = fSum.concat("1");

        return reverse(fSum);
    }

    private static String sumWithNegative(String one, String two){
        int mulForOne = one.charAt(0) == '-' ? -1:1;
        int mulForTwo = two.charAt(0) == '-' ? -1:1;

        int lengthForOne = mulForOne == 1 ? one.length() - 1 : one.length() - 2;
        int lengthForTwo = mulForTwo == 1 ? two.length() - 1 : two.length() - 2;

        int min = lengthForOne > lengthForTwo ? lengthForTwo: lengthForOne;

        if(mulForOne == -1)
            lengthForOne++;
        if(mulForTwo == -1)
            lengthForTwo++;

        if(lengthForOne > -1 && lengthForTwo > -1){
            if(mulForOne == -1 && mulForTwo == -1 || mulForOne == 1 && mulForTwo == 1){
                if(mulForOne == -1)
                    return "-" + sum(one.substring(1), two.substring(1));
                return sum(one, two);
            }
            else if(mulForOne == -1 && mulForTwo == 1){
                String temp = one.substring(1);
                if(oneISGreaterThanTwo(temp, two)){
                    return "-" + Subtract(temp, two, min, lengthForOne - 1, lengthForTwo);
                }
                else{
                    return Subtract(two, temp, min, lengthForTwo, lengthForOne - 1);
                }
            }
            else if(mulForOne == 1 && mulForTwo == -1){
                String temp = two.substring(1);
                if(oneISGreaterThanTwo(temp, one)){
                    return "-" + Subtract(temp, one, min, lengthForTwo - 1 , lengthForOne);
                }
                else{
                    return Subtract(one, temp, min, lengthForOne, lengthForTwo - 1);
                }
            }
        }
        return "";
    }

    private static String Subtract(String one, String two, int min, int lengthForOne, int lengthForTwo){
        int sum;
        int lend = 0;
        String fSum = "";

        for(int i = 0; i <= min; i++){
            sum = Character.getNumericValue(one.charAt(lengthForOne)) - Character.getNumericValue(two.charAt(lengthForTwo)) - lend;
            if(sum < 0){
                sum = Character.getNumericValue(one.charAt(lengthForOne)) - Character.getNumericValue(two.charAt(lengthForTwo)) + 10 - lend;
                lend = 1;
            }
            else
                lend = 0;

            lengthForOne--;
            lengthForTwo--;

            fSum += sum;
        }

        if(lengthForOne <= -1){
            for(int i = lengthForTwo; i >= 0; i--){
                fSum = fSum + (Character.getNumericValue(two.charAt(i)) - lend);
            }
        }
        else {
            for(int i = lengthForOne; i >= 0; i--){
                fSum = fSum + (Character.getNumericValue(one.charAt(i)) - lend);
            }
        }

        return reverse(fSum);
    }

    private static String Multiply(String one, String two){
        int mulForOne = one.charAt(0) == '-' ? -1:1;
        int mulForTwo = two.charAt(0) == '-' ? -1:1;

        int lengthOfOne = mulForOne == 1 ? one.length() - 1 : one.length() - 2;//1
        int lengthOfTwo = mulForTwo == 1 ? two.length() - 1 : two.length() - 2;//1

        boolean isOneTheMin = lengthOfOne < lengthOfTwo;//f

        if(isOneTheMin) {
            if (mulForOne == -1 && mulForTwo == -1 || mulForOne == 1 && mulForTwo == 1)
                return mul(two, one, lengthOfTwo, lengthOfOne);
            else
                return "-" + mul(two, one, lengthOfTwo, lengthOfOne);
        }
        else {
            if (mulForOne == -1 && mulForTwo == -1 || mulForOne == 1 && mulForTwo == 1)
                return mul(one, two, lengthOfOne, lengthOfTwo);
            else
                return "-" + mul(one, two, lengthOfOne, lengthOfTwo);
        }
    }

    private static String mul(String one, String two, int lengthOne, int lengthTwo){
        int mul;
        int carry = 0;
        int count = 0;
        ArrayList<String> listOfMulInOneLine = new ArrayList<>();
        ArrayList<Integer> indexOfMulInOneLine = new ArrayList<>();

        String mulOfOneNum;
        for (int i = lengthTwo; i >= 0; i--){
            count++;
            mulOfOneNum = "";
            for (int j = lengthOne; j >= 0; j--){
                mul = Character.getNumericValue(two.charAt(i)) * Character.getNumericValue(one.charAt(j)) + carry;
                carry = 0;
                if(mul >= 10){
                    carry = mul / 10;
                    mul %= 10;
                }
                mulOfOneNum = mulOfOneNum.concat(Integer.toString(mul));
                if(indexOfMulInOneLine.size() < count) {
                    indexOfMulInOneLine.add(0);
                }
                else {
                    int index1 = indexOfMulInOneLine.get(count - 1);
                    indexOfMulInOneLine.remove(count - 1);
                    indexOfMulInOneLine.add(count - 1, index1 + 1);
                }
            }

            if(carry > 0)
                mulOfOneNum = mulOfOneNum.concat(Integer.toString(carry));

            listOfMulInOneLine.add(reverse(mulOfOneNum));
        }

        String Sum = "";
        int count2 = 0;
        carry = 0;
        for (int i = 0; i <= lengthOne + lengthTwo - 1; i++){
            int sum = 0;
            for (int j = 0; j <= i; j++){
                if(j <= lengthTwo && indexOfMulInOneLine.get(j) >= 0){
                    sum += Character.getNumericValue(listOfMulInOneLine.get(j).charAt(indexOfMulInOneLine.get(j)));
                    int index = indexOfMulInOneLine.get(j);
                    indexOfMulInOneLine.remove(j);
                    indexOfMulInOneLine.add(j, index - 1);
                }
            }
            sum += carry;
            carry = 0;
            if(sum >= 10){
                carry = sum / 10;
                sum = sum % 10;
            }
            Sum = Sum.concat(Integer.toString(sum));
        }

        count = Character.getNumericValue(listOfMulInOneLine.get(listOfMulInOneLine.size() - 1).charAt(0)) + carry;
        Sum = Sum.concat(Integer.toString(count));
        return reverse(Sum);
    }

    private static String reverse(String num){
        StringBuilder finalNumber = new StringBuilder();

        for(int i = num.length() - 1; i >= 0; i--){
            finalNumber.append(num.charAt(i));
        }

        return finalNumber.toString();
    }

    private static boolean oneISGreaterThanTwo(String one, String two){
        if(one.length() > two.length())
            return true;
        else if(two.length() > one.length())
            return false;
        else {
            for (int i = 0; i < one.length(); i++){
                if(Character.getNumericValue(one.charAt(i)) > Character.getNumericValue(two.charAt(i)))
                    return true;
                else if(Character.getNumericValue(one.charAt(i)) < Character.getNumericValue(two.charAt(i)))
                    return false;
            }
        }
        return false;
    }
}