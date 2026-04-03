class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> freqMap = new TreeMap<>();

        for(int card: hand) {
            freqMap.put(card, freqMap.getOrDefault(card, 0) +1);
        }
        while(!freqMap.isEmpty()) {
            int currLowest =freqMap.firstKey();
            for(int i = currLowest;  i< currLowest + groupSize; i++) {
                if(!freqMap.containsKey(i)) return false;
                freqMap.put(i, freqMap.get(i) -1);
                if(freqMap.get(i) == 0) {
                    freqMap.remove(i);
                }
            }

        }
        return true;
    }
}
