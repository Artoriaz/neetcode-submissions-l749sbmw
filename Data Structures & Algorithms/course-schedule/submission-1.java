class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] preq: prerequisites) {
            indegree[preq[0]]++;
            graph.get(preq[1]).add(preq[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int pop = q.poll();
            for(int neigh: graph.get(pop)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.add(neigh);
            }
        }
        for(int i: indegree) {
            if(i > 0) return false;
        }
        return true;
    }
}
