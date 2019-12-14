import java.util.*;

public class CodeForceContestQuestionSnowWalkingRobot {

    public static void main(String[] args) {
        SnowWalkingRobot();
    }

    public static void SnowWalkingRobot(){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            String instruction = scanner.next();
            rearrangeSequencesOfInstructions(instruction);
        }
        scanner.close();
    }

    public static void rearrangeSequencesOfInstructions(String instruction) {
        int DCount = 0, UCount = 0, RCount = 0, LCount = 0;
        StringBuilder finalInstruction = new StringBuilder();

        // (DCount == 0 && UCount != 0) || (RCount != 0 && LCount == 0)
        for (int i = 0; i < instruction.length(); i++) {
            if(instruction.charAt(i) == 'D')
                DCount++;
            else if(instruction.charAt(i) == 'U')
                UCount++;
            else if(instruction.charAt(i) == 'R')
                RCount++;
            else if(instruction.charAt(i) == 'L')
                LCount++;
        }

        DCount = DCount < UCount ? DCount : UCount;
        RCount = RCount < LCount ? RCount : LCount;

        if( RCount == 0 && DCount == 0){
            System.out.println(0);
            System.out.println();
            return;
        }

        if( RCount == 0 && DCount > 1){
            System.out.println(2);
            System.out.println("DU");
            return;
        }
        if( DCount == 0 && RCount > 1){
            System.out.println(2);
            System.out.println("RL");
            return;
        }

        for (int i = 0; i < DCount; i++) {
            finalInstruction.append("D");
        }

        for (int i = 0; i < RCount; i++) {
            finalInstruction.append("R");
        }

        for (int i = 0; i < DCount; i++) {
            finalInstruction.append("U");
        }

        for (int i = 0; i < RCount; i++) {
            finalInstruction.append("L");
        }

        System.out.println(DCount * 2 + RCount * 2);
        System.out.println(finalInstruction.toString());
    }
}