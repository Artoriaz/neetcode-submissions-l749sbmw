class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        boolean cycle = false;
        //build the schedule
        for(int i =0 ; i < numCourses; i++) adj.add(new ArrayList<>());
        //create graph
        for(int[] preq: prerequisites) {
            adj.get(preq[0]).add(preq[1]);
        }
        int[] state  = new int[numCourses];
        Arrays.fill(state, 0);
        for(int i = 0; i < adj.size(); i++) {
            if(dfs(answer,adj, state,i)) return new int[0];
        }
        //create course schedule
        //cycle detection

        return answer.stream().mapToInt(i -> i).toArray();
    }
    // really this is a dfs to check if we are in a cycle
    public boolean dfs(List<Integer> answer, List<List<Integer>> adj, int[] state, int i) {
        if(state[i] == 1) return true;
        if(state[i] ==2 ) return false;
        state[i] = 1;
        for(int neighbor: adj.get(i)) {
                if(dfs(answer,adj,state,neighbor)) return true;
        }
        state[i] = 2;
        answer.add(i);
        return false;
    }
}
