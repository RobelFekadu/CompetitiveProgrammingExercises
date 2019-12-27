import java.util.*;

public class CodeForceContestQuestionRemoveOneElement {

    public static void main(String[] args) {
        RemoveOneElement();
    }

    public static void RemoveOneElement(){
        Scanner scanner = new Scanner(System.in);
        
        int arrayLength = scanner.nextInt();
        int[] numbersArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            numbersArray[i] = scanner.nextInt();
        }
        
        System.out.println(getMaximumLengthOfStrictlyIncreasingArray(numbersArray));
        scanner.close();
    }

    public static int  getMaximumLengthOfStrictlyIncreasingArray(int[] numbersArray){
        int maxLength = 1, tempLength = 1, tempValue = 0;
        boolean canRemove = true, canRemove2 = true;
        
        for (int i = 0; i < numbersArray.length - 1; i++) {
            if(!canRemove){
                if(tempValue < numbersArray[i + 1]){
                    tempLength++;
                    tempValue = numbersArray[i + 1];
                    canRemove2 = false;
                }
                else if(canRemove2 && i - 2 >= 0 && numbersArray[i] < numbersArray[i + 1] && numbersArray[i - 2] < numbersArray[i]){
                    tempLength++;
                    tempValue = numbersArray[i + 1];
                    canRemove2 = false;
                }
                else{
                    if(tempLength > maxLength){
                        maxLength = tempLength;
                    }
                    tempLength = 1;
                    canRemove = true;
                    canRemove2 = true;
                    tempValue = 0;

                    if(numbersArray[i] < numbersArray[i + 1])
                        tempLength++;
                }
            }
            else if(numbersArray[i] < numbersArray[i + 1]){
                tempLength++;
            }
            else{
                if(tempLength > 1){
                    tempValue = numbersArray[i];
                    canRemove = false;
                }
            }
        }

        if(tempLength > maxLength)
            maxLength = tempLength;

        return maxLength;
    }
}