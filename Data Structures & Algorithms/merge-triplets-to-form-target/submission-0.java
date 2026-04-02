class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a =0;
        int b = 0;
        int c =0;

        for(int[] arr : triplets) {
            if(arr[0] <= target[0] && arr[1] <= target[1] && arr[2] <= target[2]) {
                a = Math.max(a, arr[0]);
                b = Math.max(b, arr[1]);
                c = Math.max(c, arr[2]);
            }
        }
        return a == target[0] && b == target[1] && c == target[2];
    }
}
