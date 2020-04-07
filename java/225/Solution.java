class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    int last;
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        last = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            last = queue.poll();
            queue.add(last);
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return last;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
