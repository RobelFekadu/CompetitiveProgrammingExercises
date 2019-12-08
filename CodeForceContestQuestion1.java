import java.util.*;

public class CodeForceContestQuestion1 {

    public static void main(String[] args) {
        BeautifulString();
    }

    public static void BeautifulString(){
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        String[] arrayOfString = new String[testCase];

        for(int i = 0; i < testCase; i++){
            arrayOfString[i] = scanner.next();
        }

        for (int i = 0; i < testCase; i++){
            System.out.println(BeautifyString(arrayOfString[i]));
        }
        scanner.close();
    }

    public static String BeautifyString(String inString){
        char[] stringArray = inString.toCharArray();
        for(int i = 0; i < stringArray.length; i++){
            if(stringArray[i] != '?' && i + 1 < stringArray.length && stringArray[i] == stringArray[i + 1])
                return "-1";
                
            if(stringArray[i] == '?'){
                    modify(stringArray, i);
            }
            
        }
        return new String(stringArray);
    }

    public static void modify(char[] stringArray, int initIndex){
        if(initIndex + 1 < stringArray.length){
            if(stringArray[initIndex + 1] == '?')
                stringArray[initIndex] = getChar(stringArray, initIndex, false);
            else
                stringArray[initIndex] = getChar(stringArray, initIndex, true);
        }
        else
            stringArray[initIndex] = getChar(stringArray, initIndex, false);
    }

    public static char getChar(char[] stringArray, int initIndex, boolean checkAfter){
        if(initIndex == 0){
            if(checkAfter){
                if(stringArray[initIndex + 1] == 'a')
                    return 'b';
                else
                    return 'a';
            }
            return 'a';
        }
        else if(checkAfter){
            if(stringArray[initIndex - 1] == stringArray[initIndex + 1]){
                if(stringArray[initIndex - 1] == 'a')
                    return 'b';
                else
                    return 'a';
            }
            else if(stringArray[initIndex - 1] == 'a' && stringArray[initIndex + 1] == 'b' || stringArray[initIndex - 1] == 'b' && stringArray[initIndex + 1] == 'a')
                return 'c';
            else if(stringArray[initIndex - 1] == 'a' && stringArray[initIndex + 1] == 'c' || stringArray[initIndex - 1] == 'c' && stringArray[initIndex + 1] == 'a')
                return 'b';
            else
                return 'a';
        }
        else{
            if(stringArray[initIndex - 1] == 'a')
                return 'b';
            else
                return 'a';
        }
    }
}