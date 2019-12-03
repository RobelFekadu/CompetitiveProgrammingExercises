import java.util.*;

public class PostfixCalculator{
    public static void main(String[] args) {
        System.out.println(Postfix("3 4 5 5 - + *"));
    }
    public static int Postfix(String input) {
        ArrayList<String> inputArray = new ArrayList<>(Arrays.asList(input.split(" ")));
        int value;
        Stack<Integer> operands = new Stack<>();
        for (int i = 0; i < inputArray.size(); i++) {
            switch (inputArray.get(i)) {
                case "/":
                    value = operands.pop();
                    operands.push( operands.pop() / value);
                    break;
                case "*":
                    value = operands.pop();
                    operands.push( operands.pop() * value);
                    break;
                case "-":
                    value = operands.pop();
                    operands.push(operands.pop() - value);
                    break;
                case "+":
                    operands.push(operands.pop() + operands.pop());
                    break;
                default:
                    operands.push(Integer.parseInt(inputArray.get(i)));
            }
        }
        return operands.pop();
    }
}