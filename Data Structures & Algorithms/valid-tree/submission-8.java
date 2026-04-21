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
        visited = new boolean[n];
        
        for(int i = 0; i < n ; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Queue<State> q = new LinkedList<>();

        q.add(new State(0, -1));

        while(!q.isEmpty()) {
            State state = q.poll();
            if(visited[state.node]) return false;
            visited[state.node] = true;
            for(int neigh: graph.get(state.node)) {
                if(neigh == state.parent) continue;
                q.add(new State(neigh, state.node));
            }
        }
        for(boolean v: visited){
            if(!v) return false;
        }
        return true;
    }
}
