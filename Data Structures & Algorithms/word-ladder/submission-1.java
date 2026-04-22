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
        q.add(new State(beginWord, 1));
        while(!q.isEmpty()) {
            State state = q.poll();
            if(state.word.equals(endWord)) return state.steps;
            for(String neigh: generateNeighbors(state.word, wordList)) {
                if(!visited.contains(neigh)) {
                    visited.add(neigh);
                    q.add(new State(neigh, state.steps +1));
                }
            }
        }


        return 0;    
    }
    public List<String> generateNeighbors(String word, List<String> wordList) {
        List<String> neighbors = new ArrayList<>();
        for(String potentialN : wordList) {
            for(int i = 0; i < word.length() ; i++) {
                String wildCardWord1 = word.substring (0, i) + '*' + word.substring (i +1);
                String wildCardWord2 = potentialN.substring (0, i) + '*' + potentialN.substring (i + 1);
                
                if(wildCardWord1.equals(wildCardWord2)) {
                neighbors.add(potentialN);
                //break;
                }
            }
        }
        return neighbors;
    }
    
}
