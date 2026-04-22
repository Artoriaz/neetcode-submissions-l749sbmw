class Solution {
    public class DSU {
        int[] parent;
        int[] rank;
        public DSU (int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i]= i;
                rank[i] = 1;
            }
        }
        public int find(int node) {
            int cur = node;
            while(cur != parent[cur]) {
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            return cur;
        }
        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return false;
            if( rank[pv] > rank[pu]) {
                int temp = pu;
                pu=pv;
                pv = temp;

            }
            parent[pv] = pu;
            rank[pu] += rank[pv]; 
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;
        for(int[] e: edges) {
            if(dsu.union(e[0], e[1])) {
                res--;
            }
        }
        return res;
    }

    
}
