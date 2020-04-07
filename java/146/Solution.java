public class LRUCache {
    private Map<Integer, DoublyLinkedNode> cacheMap;
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private int emptyCells;
    
    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        head = new DoublyLinkedNode();
        tail = new DoublyLinkedNode();
        head.next = tail;
        tail.prev = head;
        emptyCells = capacity;
    }
    
    public int get(int key) {
        DoublyLinkedNode node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addFirst(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        DoublyLinkedNode node = cacheMap.get(key);
        if (node == null) {
            if (emptyCells == 0) {
                DoublyLinkedNode removedNode = removeLast();
                if (removedNode == null) {
                    return;
                }
                cacheMap.remove(removedNode.key);
                emptyCells++;
            }
            node = new DoublyLinkedNode(key, value);
            addFirst(node);
            cacheMap.put(key, node);
            emptyCells--;
        } else {
            node.value = value;
            removeNode(node);
            addFirst(node);
        }
    }
    
    private void addFirst(DoublyLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private DoublyLinkedNode removeLast() {
        if (tail.prev == head) {
            return null;
        }
        DoublyLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
    
    private void removeNode(DoublyLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
    
    private class DoublyLinkedNode {
        private int key;
        private int value;
        private DoublyLinkedNode prev;
        private DoublyLinkedNode next;
        
        private DoublyLinkedNode() {
            this(0, 0);
        }
        
        public DoublyLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
