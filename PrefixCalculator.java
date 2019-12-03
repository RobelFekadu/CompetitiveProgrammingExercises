import java.util.*;

public class PrefixCalculator{
    public static void main(String[] args) {
        System.out.println(Prefix("- * + 3 4 5 5"));
    }
    public static int Prefix(String input) {
        ArrayList<String> inputArray = new ArrayList<>(Arrays.asList(input.split(" ")));
        Stack<Integer> operands = new Stack<>();
        for (int i = inputArray.size() - 1; i >= 0; i--) {
            switch (inputArray.get(i)) {
                case "/":
                    operands.push(operands.pop() / operands.pop());
                    break;
                case "*":
                    operands.push( operands.pop() * operands.pop());
                    break;
                case "-":
                    operands.push(operands.pop() - operands.pop());
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