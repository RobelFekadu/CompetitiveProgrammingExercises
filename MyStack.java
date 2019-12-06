import java.util.*;

public class MyStack {
    CustomQueue customQueue = new CustomQueue();
    CustomQueue customQueue2 = new CustomQueue();

    /** Push element x onto stack. */
    public void push(int x) {
        customQueue.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (customQueue.size() != 1){
            customQueue2.push(customQueue.pop());
        }
        int num = customQueue.pop();
        while (customQueue2.size() != 0){
            customQueue.push(customQueue2.pop());
        }
        return num;
    }

    /** Get the top element. */
    public int top() {
        while (customQueue.size() != 1){
            customQueue2.push(customQueue.pop());
        }
        int num = customQueue.peek();
        customQueue2.push(customQueue.pop());
        while (customQueue2.size() != 0){
            customQueue.push(customQueue2.pop());
        }
        return num;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return customQueue.empty();
    }
}

class CustomQueue {
    ArrayList<Integer> queue = new ArrayList<>();

    public void push(Integer integer){
        queue.add(integer);
    }

    public Integer pop(){
        int num = queue.get(0);
        queue.remove(0);
        return num;
    }

    public Integer peek(){
        return queue.get(0);
    }

    public boolean empty(){
        return queue.size() == 0;
    }

    public int size(){
        return queue.size();
    }
}