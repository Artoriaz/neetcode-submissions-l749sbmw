class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        // create hash map with indicies as secondary value
        // find complement of target and current number. 
        // check to see if value exists in hashMap, starting from lowest, we check BEFORE we add
        for(int i = 0; i<numbers.length; i++) {
            hashMap.put(numbers[i], i);
        }

        for(int num: numbers) {
            int complement = target - num;

            if(hashMap.containsKey(complement)) {
                return new int[] {hashMap.get(num) +1, hashMap.get(complement) + 1  };
            }
            
        }

        return new int[0];
    }
}
