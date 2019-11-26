import java.util.*;

public class MathOperationsOnHugeNumbers{
    static int cntt = 0;
    public static void main(String[] args) {
        //System.out.println(sum("123123123159", "5923423423432"));
        //System.out.println(sumWithNegative("102342342348", "-24345345345"));
        //System.out.println(Multiply("10000002233", "1234567676767"));
        //System.out.println("final: " + Divide("5923423423432", "130"));
        System.out.println("final: " + Divide("35", "120"));
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

    private static String Divide(String one, String two){
        int lengthForOne = one.length();
        int lengthForTwo = two.length();
        String finalString = "";
        boolean inPoint = false;
        ArrayList<String> QuotientAndRem;
        int count = 0;

        while(true){
            QuotientAndRem = new ArrayList<>();
            if(lengthForOne >= lengthForTwo){
                String tempLeft = one.substring(0, lengthForTwo);
                String tempRight = one.substring(lengthForTwo, one.length());
                if(oneISGreaterThanTwo(tempLeft, two)){
                    QuotientAndRem = divide(tempLeft, two);
                }
                else{
                    tempLeft = one.substring(0, lengthForTwo + 1);
                    tempRight = one.substring(lengthForTwo + 1, one.length());
                    QuotientAndRem = divide(tempLeft, two);
                }

                finalString += QuotientAndRem.get(0);
                tempRight = removeZeroAtFront(QuotientAndRem.get(1)) + tempRight;

                if(tempRight.equals("0") || tempRight.equals("") || tempRight.equals(" "))
                    break;

                if(oneISGreaterThanTwo(two, tempRight)){
                    if(!inPoint){
                        finalString += ".";
                        inPoint = true;
                    }

                    tempRight = addZeros(tempRight, two);   
                }
                one = tempRight;
            }
            else{
                if(!inPoint){
                    finalString += ".";
                    inPoint = true;
                }
                one = addZeros(one, two);
            }

            lengthForOne = one.length();
            lengthForTwo = two.length();

            if(inPoint)
                count++;
            if(count >= 5)
                break;
        }

        return finalString;
    }

    private static ArrayList<String> divide(String one, String two){
        int diviser = 1;
        String temp2 = two;
        ArrayList<String> QuotientAndRem = new ArrayList<>();
        while(true){
            if(oneISGreaterThanTwo(sum(temp2, two), one))
                break;
            diviser++;
            temp2 = sum(temp2, two);
        }

        String rem = removeZeroAtFront(sumWithNegative(one, "-" + temp2));
        QuotientAndRem.add(Integer.toString(diviser));
        if(rem.equals(""))
            QuotientAndRem.add("0");
        else
            QuotientAndRem.add(rem);
        return QuotientAndRem;
    }

    private static String addZeros(String small, String big){
        int diff = big.length() - small.length();
        int count = 0;
        for(int i = 0; i < diff; i++){
            small = small + "0";
            count++;
        }

        if(oneISGreaterThanTwo(big, small)){
            small = small + "0";
            count++;
        }
        return small + Integer.toString(count);
    }

    private static String removeZeroAtFront(String string){
        while(string.charAt(0) == '0'){
            string = string.substring(1, string.length());
            if(string.length() == 0)
                return "";
        }
        return string;
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