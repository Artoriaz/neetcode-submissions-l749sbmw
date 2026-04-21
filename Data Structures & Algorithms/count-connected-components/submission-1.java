class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int islands = 0;
        for(int node : graph.keySet()) {
            if(!visited.contains(node)) {
                visited.add(node);
                islands++;
                bfs(node);
            }
        }
        return islands;
        
    }
    public void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
             int state =q.poll();

             for(int neigh: graph.get(state)) {
                if(!visited.contains(neigh)) {
                    visited.add(neigh);
                    q.add(neigh);
                }
             }
        }
    }
}
