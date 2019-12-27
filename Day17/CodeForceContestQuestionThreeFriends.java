import java.util.*;

public class CodeForceContestQuestionThreeFriends {

    public static void main(String[] args) {
        ThreeFriends();
    }

    public static void ThreeFriends(){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            int[] initialPositions = new int[3];
            for (int j = 0; j < 3; j++) {
                initialPositions[j] = scanner.nextInt();
            }
            System.out.println(getMinimumTotalPairwiseDistance(initialPositions));
        }
        scanner.close();
    }

    public static int getMinimumTotalPairwiseDistance(int[] initialPositions){
        if(initialPositions[0] == initialPositions[1] && initialPositions[1] == initialPositions[2]){
            return 0;
        }
        int maxIndex = 0;
        int minIndex = 0;
        int midIndex = 0;

        for (int i = 1; i < 3; i++) {
            if(initialPositions[minIndex] > initialPositions[i])
                minIndex = i;
            if(initialPositions[maxIndex] < initialPositions[i])
                maxIndex = i;
        }

        for (int i = 0; i < 3; i++) {
            if(i != minIndex && i != maxIndex)
                midIndex = i;
        }

        if(initialPositions[midIndex] == initialPositions[minIndex]){
            initialPositions[maxIndex]--;
            if(initialPositions[midIndex] < initialPositions[maxIndex]){
                initialPositions[minIndex]++;
                initialPositions[midIndex]++;
            }
        }
        else if(initialPositions[midIndex] == initialPositions[maxIndex]){
            initialPositions[minIndex]++;
            if(initialPositions[midIndex] > initialPositions[minIndex]){
                initialPositions[maxIndex]--;
                initialPositions[midIndex]--;
            }
        }
        else{
            initialPositions[minIndex]++;
            initialPositions[maxIndex]--;
        }

        return Math.abs(initialPositions[0] - initialPositions[1]) + Math.abs(initialPositions[0] - initialPositions[2]) + Math.abs(initialPositions[1] - initialPositions[2]);
    }
}