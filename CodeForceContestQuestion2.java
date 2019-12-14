import java.util.*;

public class CodeForceContestQuestion2 {

    public static void main(String[] args) {
        BeautifulNumbers();
    }

    public static void  BeautifulNumbers(){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][] arrayOfNumbers = new int[testCases][];

        for(int i = 0; i < testCases; i++){
            int inputNumbersCount = scanner.nextInt();
            int[] inputNumbersArray = new int[inputNumbersCount];
            for (int j = 0; j < inputNumbersCount; j++) {
                inputNumbersArray[j] = scanner.nextInt();
            }

            arrayOfNumbers[i] = inputNumbersArray;
        }

        for (int i = 0; i < testCases; i++){
            System.out.println(CheckBeautifulNumber(arrayOfNumbers[i]));
        }
        scanner.close();
    }

    private static String CheckBeautifulNumber(int[] inputNumbers) {
        int min, max;
        int[] numbersIndex = new int[inputNumbers.length];
        StringBuilder result = new StringBuilder();

        HashMap<String, Integer> sdf = new HashMap<>();
        sdf.g
        for (int i = 0; i < inputNumbers.length; i++) {
            numbersIndex[inputNumbers[i] - 1] = i;
        }

        min = numbersIndex[0];
        max = numbersIndex[0];

        for (int i = 0; i < numbersIndex.length; i++) {
            min = min > numbersIndex[i] ? numbersIndex[i] : min;
            max = max < numbersIndex[i] ? numbersIndex[i] : max;

            if (max - min == i)
                result.append('1');
            else 
                result.append('0');
        }

        return result.toString();
    }

    private static int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> positionAndSpeedMap = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            positionAndSpeedMap.put(position[i], speed[i]);
            positionAndSpeedMap.get(key)
        }

        for (int i = 0; i < position.length; i++) {
            
        }
    }
}