import java.util.*;

public class ValidParantheses{

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stackForBracket = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stackForBracket.push('(');
            }
            else if(s.charAt(i) == '['){
                stackForBracket.push('[');
            }
            else if(s.charAt(i) == '{'){
                stackForBracket.push('{');
            }
            else if(s.charAt(i) == ')'){
                if(stackForBracket.empty()){
                    return false;
                }
                if(stackForBracket.pop() != '(')
                    return false;
            }
            else if(s.charAt(i) == ']'){
                if(stackForBracket.empty())
                    return false;
                if(stackForBracket.pop() != '[')
                    return false;
            }
            else if(s.charAt(i) == '}'){
                if(stackForBracket.empty()){
                    return false;
                }
                if(stackForBracket.pop() != '{')
                    return false;
            }
        }

        return stackForBracket.empty();
    }
}