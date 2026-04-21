class Solution {
    private List<Integer> answer = new ArrayList<>();
    private int[] indegree;
    Map<Integer, List<Integer>> graph;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        graph = new HashMap<>();
        //build  graphabstract
        for(int i=0; i< numCourses; i++) {
             graph.put(i, new ArrayList<>());
        };
        for(int[] preq: prerequisites) {
            indegree[preq[0]]++;
            graph.get(preq[1]).add(preq[0]);
        }


        for(int i=0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                dfs(i);
            }
        }
        return answer.size() == numCourses ? answer.stream().mapToInt(i -> i).toArray() : new int[0];
    }
    public void dfs(int node) {
        answer.add(node);
        indegree[node]--;
        for(int neighbor: graph.get(node)) {
            indegree[neighbor]--;
            if(indegree[neighbor] == 0) {
                dfs(neighbor);
            }
        }
    }
}
