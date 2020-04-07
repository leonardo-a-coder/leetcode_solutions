public class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack;
    private Integer next;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        if (nestedList != null) {
            stack.push(nestedList.iterator());
            moveForward();
        }
    }

    @Override
    public Integer next() {
        Integer result = next;
        moveForward();
        return result;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
    
    private void moveForward() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> iter = stack.peek();
            if (iter.hasNext()) {
                NestedInteger ni = iter.next();
                if (ni.isInteger()) {
                    next = ni.getInteger();
                    return;
                } else {
                    stack.push(ni.getList().iterator());
                }
            } else {
                stack.pop();
            }
        }
        next = null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
