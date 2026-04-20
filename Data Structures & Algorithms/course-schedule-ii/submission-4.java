class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> answer = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>(); 

        Map<Integer, List<Integer>> graph = new HashMap<>();
        //build  graphabstract
        for(int i=0; i< numCourses; i++) {
             graph.put(i, new ArrayList<>());
        };
        for(int[] preq: prerequisites) {
            indegree[preq[0]]++;
            graph.get(preq[1]).add(preq[0]);
        }


        for(int i=0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int pop = q.poll();
            answer.add(pop);
            for(int next: graph.get(pop)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.add(next);
                }
            }


        }
        return answer.size() == numCourses ? answer.stream().mapToInt(i->i).toArray() : new int[0];
        
    }
    
}
