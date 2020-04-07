public class ZigzagIterator {
    List<Iterator<Integer>> iterators;
    int index;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new LinkedList<>();
        if (!v1.isEmpty()) {
            iterators.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            iterators.add(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> iter = iterators.get(index);
        int result = iter.next();
        if (iter.hasNext()) {
            index++;
        } else {
            iterators.remove(iter);
        }
        if (index == iterators.size()) {
            index = 0;
        }
        return result;
    }

    public boolean hasNext() {
        return !iterators.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
