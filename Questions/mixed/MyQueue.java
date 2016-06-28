import java.util.Stack;

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        if (stack1.empty()) {
            stack2.push(x);
        } else {
            stack1.push(x);
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack1.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
            stack1.pop();
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }else
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            stack2.pop();
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
    }

    // Get the front element.
    public int peek() {
        int peek = 0;
        if(stack1.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
            peek = stack1.peek();
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }

        }else
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            peek= stack2.peek();

            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        return peek;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }


}