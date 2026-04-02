class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());


        for(int num: nums) {   
            heap.add(num); 
        }
        while(k > 1) {
            heap.poll();
            k--;
        }
        return heap.peek();

    }
}
