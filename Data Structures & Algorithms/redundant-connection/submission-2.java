class Solution {
    public class DSU {
        int[] parent;
        int[] rank;
        public DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i]  = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            int temp = node;
            while( temp != parent[temp]) {
                parent[temp] = parent[parent[temp]];
                temp = parent[temp];
            }
            return temp;
        }
        public boolean union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            // if they have the same parent they're already connected
            if(parentA == parentB) return false;

            if(rank[parentA] >= rank[parentB]) {
                parent[parentB] = parentA;
                rank[parentA] += rank[parentB];
            } else {
                parent[parentA] = parentB;
                rank[parentB] += rank[parentB];
            }

            return true;
            
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n +1);
        for(int[] e: edges) {
            if(!dsu.union(e[0], e[1])) return e;
        }
        return new int[0];
    }
}
