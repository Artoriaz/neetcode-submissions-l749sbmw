class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1 );

        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a ,b) -> freqMap.get(a) - freqMap.get(b));

        for(int freq :freqMap.keySet()) {
            heap.add(freq);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        int[] answer = new int[k];

        for(int i=0; i<k; i++) {
            answer[i] = heap.poll();
        }
        return answer;
    }
}
