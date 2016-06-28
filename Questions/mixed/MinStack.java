import java.util.Stack;

class MinStack {
    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() > x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (!dataStack.isEmpty()) {
            int d = dataStack.pop();
            if (minStack.peek() == d) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!dataStack.isEmpty())
            return dataStack.peek();
        else {
            return -1;
        }
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        } else return minStack.peek();
    }

}
