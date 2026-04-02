class LRUCache {
    HashMap<Integer,Integer> cache;
    LinkedList<Integer> list;;
    int currentSize = 1;
    int maxSize;
    public LRUCache(int capacity) {
        list = new LinkedList<>();
        cache = new HashMap<>();
        maxSize = capacity;
    }
    
    public int get(int key) {
       if(cache.containsKey(key)) {
           list.remove((Integer) key);
           list.add(key);
           return cache.get(key);
       } else return -1;
    }
    
    public void put(int key, int value) {
        cache.put(key,value);
        if(cache.containsKey(key)) {
            list.remove((Integer) key);
        }
        list.add(key);
        if(cache.size() > maxSize) {
            int removed = list.removeFirst();
            cache.remove(removed);
        }
    }
}
