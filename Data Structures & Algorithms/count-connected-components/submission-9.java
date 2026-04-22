
class Solution {
    public class DSU {
        int[] rank;
        int[] parent;
        public DSU(int n) {
            this.rank = new int[n];
            this.parent = new int[n];
            for(int i =0 ; i < n; i++) {
                this.parent[i] = i;
            }
            Arrays.fill(this.rank, 1);

        }
        //find parent
        public int find(int node) {
            int temp = node;
            while( temp != parent[temp]) {
                // optimization to set the parent equal to grandparent? unsure
                parent[temp] = parent[parent[temp]];
                temp = parent[temp];
            }

            return temp;

        }
        //union / aka connect them;
        public boolean union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            // already connected.
            if( parentA == parentB) return false;

            if(rank[parentA] >= rank[parentB]) {
                rank[parentA] += rank[parentB];
                parent[parentB] = parentA;
            } else {
                rank[parentB] += rank[parentA];
                parent[parentA] = parentB;
            }
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int numberOfComponents = n;
        for(int[] e: edges) {
            if(dsu.union(e[0], e[1])) {
                numberOfComponents--;
            }
        }
        return numberOfComponents;
    }
}
