class MyQueue {
    private Stack<Integer> headStack;
    private Stack<Integer> tailStack;
    
    public MyQueue() {
        headStack = new Stack<>();
        tailStack = new Stack<>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        tailStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (headStack.isEmpty()) {
            move();
        }
        headStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (headStack.isEmpty()) {
            move();
        }
        return headStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return headStack.isEmpty() && tailStack.isEmpty();
    }
    
    private void move() {
        while (!tailStack.isEmpty()) {
            headStack.push(tailStack.pop());
        }
    }
}
