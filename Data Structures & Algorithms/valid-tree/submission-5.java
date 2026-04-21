class Solution {
    HashMap<Integer, List<Integer>> graph;
    boolean[] visited;
    public boolean validTree(int n, int[][] edges) {
         graph = new HashMap<>();
         visited = new boolean[n];

        //graph creation
         for(int i = 0 ; i < n; i++) {
            graph.put(i, new ArrayList<>());
         }
         for(int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
         }
         if(!dfs(0, -1)) return false;

         for(boolean v : visited) {
           if(!v) return false;
            }
        return true;

    }
    public boolean dfs(int node, int parent) {
        if(visited[node]) return false;
        visited[node]= true;
        for(int neigh: graph.get(node)) {
                if(parent == neigh ) continue;
                if(visited[neigh]) return false;    
                if(!dfs(neigh, node)) return false;
            }
            return true;
        }
        
    }
