class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        //graph creation
         for(int i = 0 ; i < n; i++) {
            graph.put(i, new ArrayList<>());
         }
         for(int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
         }
         visited.add(0);
         if(!dfs(0, -1)) return false;

         return visited.size() == n;

    }
    public boolean dfs(int node, int parent) {
        
        for(int neigh: graph.get(node)) {
                if(parent == neigh ) continue;
                if(visited.contains(neigh)) return false;
                visited.add(neigh);
                if(!dfs(neigh, node)) return false;
            }
            return true;
        }
        
    }
