class Solution {
    public class State {
        int[] coords;
        int eudDist;
        public State(int[] coords, int eudDist) {
            this.coords = coords;
            this.eudDist = eudDist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<State> maxHeap = new PriorityQueue<>((x,y) -> y.eudDist - x.eudDist);

        for(int[] coords: points) {
            int dist = euclidianDistance(coords);
            maxHeap.add(new State(coords, dist));
            while(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<int[]> answer = new ArrayList<>();

        while(!maxHeap.isEmpty()) {
            State s = maxHeap.poll();
            answer.add(s.coords);
        }
         return answer.toArray(new int[0][]);



    }
    private int euclidianDistance(int[] points) {
        int x = points[0], y = points[1];
        return (x * x )+ (y * y);
    }
}
