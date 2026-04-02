class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones) {
            heap.add(stone);
        }

        while(heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();

            if(x != y) {
                int z = Math.abs(x - y);
                heap.add(z);
            }
        }
        
        if(heap.size() == 0) return 0;
        return heap.peek();
    }
}
