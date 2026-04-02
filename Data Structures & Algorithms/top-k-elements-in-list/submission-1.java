class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        // means that only added smallest values ? 
        PriorityQueue<Integer> heap = new PriorityQueue<>( (x1, x2) -> freqMap.get(x1) - freqMap.get(x2));
        for(int val: freqMap.keySet()) {
            heap.add(val);
            if(heap.size() > k) {
                heap.remove();
            }
        }
        int[] answer = new int[k];
        for(int i=0; i<k; i++) {
            answer[i] = heap.remove();
        }
        return answer;
        }
    }