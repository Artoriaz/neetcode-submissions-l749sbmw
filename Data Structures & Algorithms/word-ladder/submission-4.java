class Solution {
    public class State {
        int steps;
        String word; 
        public State(String word, int steps) {
            this.steps = steps;
            this.word = word;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        Map<String, List<String>> graph = new HashMap<>();
        for(String word: wordList) {
            for(int i = 0; i < word.length(); i++) {
                String wildcard = word.substring(0,i) + '*' + word.substring(i+1);
                graph.computeIfAbsent(wildcard, k -> new ArrayList<>()).add(word);
            }
        }
        q.add(new State(beginWord, 1));
        while(!q.isEmpty()) {
            State state = q.poll();
            if(state.word.equals(endWord)) return state.steps;
            for(String neigh: generateNeighbors(state.word, wordList, graph)) {
                if(!visited.contains(neigh)) {
                    visited.add(neigh);
                    q.add(new State(neigh, state.steps +1));
                }
            }
        }


        return 0;    
    }
    public List<String> generateNeighbors(String word, List<String> wordList, Map<String, List<String>> graph) {
        List<String> neighbors = new ArrayList<>();
        for(String potentialN : wordList) {
            for(int i = 0; i < word.length() ; i++) {
                String wildcard = word.substring (0, i) + '*' + word.substring (i +1);
                if(graph.containsKey(wildcard)) neighbors.addAll(graph.get(wildcard));
            }
        }
        return neighbors;
    }
    
}
