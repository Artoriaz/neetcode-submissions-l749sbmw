class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        int islands = 0;
        for(int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        // do we need a last seen node?
        for(int node: graph.keySet()) {
            if(!visited.contains(node)) {
                islands++;
                //visited.add(node);
                dfs(node /* parent */);
            }
        }
        return islands;
    }
    public void dfs(int node) {
        visited.add(node);
        for(int neigh: graph.get(node)) {
            if(!visited.contains(neigh)) {
                dfs(neigh);
            } 
        }
    }
}
