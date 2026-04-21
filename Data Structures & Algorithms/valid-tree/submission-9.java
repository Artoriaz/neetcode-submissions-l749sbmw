class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] visited;
    public class State {
        int node;
        int parent;
        public State(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean validTree(int n, int[][] edges) {
       Set<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < n ; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Queue<State> q = new LinkedList<>();

        q.add(new State(0, -1));
        visited.add(0);
        while(!q.isEmpty()) {
            State state = q.poll();
            for(int neigh: graph.get(state.node)) {
                if(neigh == state.parent) continue;
                if(visited.contains(neigh)) return false;
                visited.add(neigh);
                q.add(new State(neigh, state.node));
            }
        }
        return visited.size() == n;
    }
}
