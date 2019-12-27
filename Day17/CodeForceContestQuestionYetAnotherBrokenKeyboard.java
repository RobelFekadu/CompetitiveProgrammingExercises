import java.util.*;

public class CodeForceContestQuestionYetAnotherBrokenKeyboard {

    public static void main(String[] args) {
        YetAnotherBrokenKeyboard();
    }

    public static void YetAnotherBrokenKeyboard(){
        Scanner scanner = new Scanner(System.in);
        
        int[] lengthAndAvailableChar = new int[2];
        
        for (int i = 0; i < 2; i++) {
            lengthAndAvailableChar[i] = scanner.nextInt();   
        }
    
        String string = scanner.next();

        String[] availableChars = new String[lengthAndAvailableChar[1]];

        for (int i = 0; i < lengthAndAvailableChar[1]; i++) {
            availableChars[i] = scanner.next();
        } 
        
        System.out.println(getSubstringCount(string, availableChars));
        scanner.close();
    }

    public static long getSubstringCount(String string, String[] availableChars) {
        int lastCheckedIndex = 0;
        long substringCount = 0;
        HashMap<Character, Character> availableCharsMap = new HashMap<>();
        for (int i = 0; i < availableChars.length; i++) {
            availableCharsMap.put(availableChars[i].charAt(0), availableChars[i].charAt(0));
        }
        
        for (int i = 0; i < string.length(); i++) {
            if( availableCharsMap.get(string.charAt(i)) == null ){
                substringCount += ( (long)(i - lastCheckedIndex) * ( (long)(i - lastCheckedIndex) + 1) ) / 2;
                lastCheckedIndex = i + 1;
            }
        }
        substringCount += ( (long)(string.length() - lastCheckedIndex) * ( (long)(string.length() - lastCheckedIndex) + 1) ) / 2;

        return substringCount;
    }
}