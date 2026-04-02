class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // this one is o(log)n;
        for(int i = 0; i< numbers.length; i++) {
            int left = i+ 1, right = numbers.length-1;
            int sum = target - numbers[i];
            while(left <= right) {
            int midP = left + (right - left) / 2;
            if(numbers[midP] < sum) {
                left = midP + 1;
            } else if (numbers[midP] > sum) {
                right = midP - 1;
            } else if(numbers[midP] == sum ){
                return new int[] {i + 1 , midP + 1};
            }
        }
        }
        return new int[0];
    }
}
