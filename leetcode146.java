class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void delete(Node node) {
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;
    }

    public void insert(Node node) {
        Node right = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = right;
        right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            delete(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (cache.containsKey(key)) {
            delete(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
        if (cache.size() > capacity) {
            Node lru = this.tail.prev;
            delete(lru);
            cache.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
