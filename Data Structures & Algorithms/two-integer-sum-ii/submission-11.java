class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0 ; i< numbers.length; i++) {
            int left = i + 1, right = numbers.length-1;
            int complement = target - numbers[i];
            while(left <= right ) {
                int mid = left + (right  - left ) / 2;
                if(numbers[mid] == complement ) {
                    return new int[] {i +1 , mid + 1};
                } else if ( numbers[mid] < complement ) {
                    left = mid + 1;
                } else if (numbers[mid] > complement ) {
                    right = mid -1;
                }
            }
        }
        return new int[0];
    }
}
