class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
       int  a = 0;
        int b = 0;
        int c = 0;

        for(int[] trip: triplets) {
            if(trip[0] <= target[0] && trip[1] <= target[1] && trip[2] <= target[2]) {
                a = Math.max(a, trip[0]);
                b = Math.max(b, trip[1]);
                c = Math.max(c, trip[2]);
            }
        }
        return a == target[0] && b == target[1] && c == target[2];
    }
}
