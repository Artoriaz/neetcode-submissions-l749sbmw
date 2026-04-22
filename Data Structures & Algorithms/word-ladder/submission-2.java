class State { 
    String word;
    int steps;
    State(String word, int steps) {
        this.steps = steps;
        this.word = word;
    }
}

class Solution {
     HashSet<String> valid;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        valid = new HashSet<>(wordList);
        HashSet<String> seen = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(beginWord, 1));
        seen.add(beginWord);
        
        
        while(!queue.isEmpty()) {
            State node = queue.poll();
            String word = node.word;
            int steps = node.steps;
            if(word.equals(endWord)) {
                return steps;
            }
            for(String neigh: getNeighbors(word)) {
                if(!seen.contains(neigh)) {
                    seen.add(neigh);
                    queue.add(new State(neigh, steps + 1));
                }
            }
        }
        return 0;
        
    }
    
    public List<String> getNeighbors(String word) {
        List<String> neighborList = new ArrayList<>();
        char[] wordAr = word.toCharArray();
        for(int i =0; i< wordAr.length;i++) {
            char original = wordAr[i];
            for(char c='a'; c<= 'z'; c++) {
                if(c == original) continue;
                wordAr[i] = c;
                String newWord = new String(wordAr);
                if(valid.contains(newWord)) {
                    neighborList.add(newWord);
                }
            }
            wordAr[i] = original;
        }
        return neighborList;
        
    }
}