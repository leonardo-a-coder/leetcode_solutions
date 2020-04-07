public class Vector2D implements Iterator<Integer> {
    private LinkedList<Iterator<Integer>> iterators;

    public Vector2D(List<List<Integer>> vec2d) {
        iterators = new LinkedList<>();
        for (List<Integer> list : vec2d) {
            if (!list.isEmpty()) {
                iterators.addLast(list.iterator());
            }
        }
    }

    @Override
    public Integer next() {
        Iterator<Integer> iter = iterators.getFirst();
        Integer result = iter.next();
        if (!iter.hasNext()) {
            iterators.removeFirst();
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return !iterators.isEmpty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
