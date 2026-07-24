class Solution {
    class State {
        int sum;
        int count;
        int coin;
        public State(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    public int coinChange(int[] coins, int amount) {
        int[] sortedCoins = Arrays.stream(coins).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        if(amount == 0) return 0;
        Queue<State> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        visited[0] = true;
        queue.add(new State(0, 0));

        while(!queue.isEmpty()) {
            State node = queue.poll();
            if(node.sum == amount) return node.count;
            for(int coin: sortedCoins) {
                if(coin > amount) continue;
                int neighbor = node.sum + coin;
                if(neighbor <= amount && !visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(new State(neighbor, node.count + 1));
                }  
            }
        }
        return -1;
    }
}
