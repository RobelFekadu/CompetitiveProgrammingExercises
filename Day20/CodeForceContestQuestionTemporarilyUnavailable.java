import java.util.*;

public class CodeForceContestQuestionTemporarilyUnavailable {

    public static void main(String[] args) {
        TemporarilyUnavailable();
    }

    public static void TemporarilyUnavailable(){
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int[][] positions = new int[testCase][];

        for(int i = 0; i < testCase; i++){
            int[] tempPositions = new int[4];
            for (int j = 0; j < 4; j++) {
                tempPositions[j] = scanner.nextInt();   
            }
            positions[i] = tempPositions;
        }

        for (int i = 0; i < testCase; i++){
            System.out.println(getNumberOfUnavailableMinutes(positions[i]));
        }
        scanner.close();
    }

    public static int  getNumberOfUnavailableMinutes(int[] positions){
        if(positions[0] > positions[1]){
            int temp = positions[1];
            positions[1] = positions[0];
            positions[0] = temp;
        }

        if(positions[2] - positions[3] <= positions[0] && positions[1] <= positions[2] + positions[3]){
            return 0;
        }

        int count = 0;

        if(positions[0] < positions[2] - positions[3] && positions[1] > positions[2] - positions[3]){
            count +=  positions[2] - positions[3] - positions[0];
        }
        if(positions[0] < positions[2] + positions[3] && positions[1] > positions[2] + positions[3]){
            count +=  positions[1] - (positions[2] + positions[3]);
        }
        if(count == 0)
            return positions[1] - positions[0];
        return count;
    }
}
     