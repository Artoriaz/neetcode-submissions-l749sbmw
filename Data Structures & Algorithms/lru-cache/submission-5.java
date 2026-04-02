class LRUCache {
    private static class Node {
        Node prev, next;
        int val, key;
        public Node(int key, int val) {
             this.val = val;
             this.key = key;
        }
    }
    private final int maxSize;
    private final HashMap<Integer, Node> cache;
    private final Node head;
    private final Node tail;
    public LRUCache(int capacity) {
        this.maxSize = capacity;
        this.cache = new HashMap<>();

        // set up sentinel nodes
        //exist outside hashmap
         head = new Node(0,0);
         tail = new Node(0,0);

        tail.next = head;
        head.prev = tail;
    }
    
    public int get(int key) {
        Node curr = cache.get(key);
        if(curr == null) return -1;
        removeNode(curr);
        addToHead(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        Node curr = cache.get(key);
        if(curr != null) {
            removeNode(curr);
            addToHead(curr);
            curr.val = value;
            return;
        } 
        Node newBy = new Node(key, value);
        cache.put(key, newBy);
        addToHead(newBy);
        if(cache.size() > maxSize) {
            Node lru = tail.next;

            removeNode(lru);
            cache.remove(lru.key);
        }
        
    }
    public void removeNode(Node n) {
        Node next = n.next;
        Node prev = n.prev;
        prev.next = next;
        next.prev = prev;
    }
    public void addToHead(Node n) {
        Node prev = head.prev;
        prev.next = n;
        n.prev = prev;
        n.next = head;
        head.prev = n;
    }
}
