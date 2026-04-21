class Solution {
    int[] indegree;
    Map<Integer, List<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        graph = new HashMap<>();

        //build graphabstract
        for(int i = 0; i< numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] preq: prerequisites ) {
            indegree[preq[0]]++;
            graph.get(preq[1]).add(preq[0]);
        }
        for(int i =0 ; i < numCourses; i++) {
            if(indegree[i] == 0) dfs(i);
        }
        for(int i =0 ; i< numCourses ;i++) {
            if(indegree[i] > 0) return false;
        }
        return true;
    }
    public void dfs(int node) {
        indegree[node]--;
        for(int neigh: graph.get(node)) {
            indegree[neigh]--;
            if(indegree[neigh] == 0) dfs(neigh);
        }
    }
}
