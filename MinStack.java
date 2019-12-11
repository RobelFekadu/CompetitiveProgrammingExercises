public class MinStack {
    int minIndex;
    ArrayList<Integer> stack;
    public MinStack() {
        stack = new ArrayList<>();
        minIndex = -1;
    }

    public void push(int x) {
        stack.add(x);
        if(minIndex == -1)
            minIndex = 0;
        else if(x < stack.get(minIndex))
            minIndex = stack.size() - 1;
    }

    public void pop() {
        if(stack.size() == 0)
            return;
        stack.remove(stack.size() - 1);
        if(minIndex == stack.size()){
            minIndex = 0;
            for (int i = 1; i < stack.size(); i++){
                if(stack.get(minIndex) > stack.get(i))
                    minIndex = i;
            }
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.get(minIndex);
    }
}