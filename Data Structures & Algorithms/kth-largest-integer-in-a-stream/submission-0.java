class KthLargest {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int maxSize;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        maxSize = k;

        for(int i =0; i< nums.length; i++) {
            minHeap.add(nums[i]);
        }
        while(minHeap.size() > maxSize) {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);

        if(minHeap.size() > maxSize) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
