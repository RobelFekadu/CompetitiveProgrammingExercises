import java.util.*;
    
public class MyQueue {

    CustomStack mainStack;
    CustomStack tempStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        mainStack = new CustomStack();
        tempStack = new CustomStack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        mainStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (mainStack.size() != 1){
            tempStack.push(mainStack.pop());
        }
        int num = mainStack.pop();

        while (!tempStack.empty()){
            mainStack.push(tempStack.pop());
        }

        return num;
    }

    /** Get the front element. */
    public int peek() {
        while (mainStack.size() != 1){
            tempStack.push(mainStack.pop());
        }
        int num = mainStack.peek();
        while (!tempStack.empty()){
            mainStack.push(tempStack.pop());
        }

        return num;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainStack.empty();
    }
}

class CustomStack{
    ArrayList<Integer> stack;

    public CustomStack(){
        stack = new ArrayList<>();
    }

    public void push(int x){
        stack.add(x);
    }

    public int pop(){
        return stack.remove(size() - 1);
    }

    public int peek(){
        return stack.get(size() - 1);
    }

    public int size(){
        return stack.size();
    }

    public boolean empty(){
        return size() == 0;
    }
}