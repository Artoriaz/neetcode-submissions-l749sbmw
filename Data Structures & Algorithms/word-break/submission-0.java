class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);

        int n = s.length();

        while(!q.isEmpty()) {
            int start = q.poll();
            for(int end = start +1; end <= n ; end++) {
                if(wordDict.contains(s.substring(start,end)) && !visited.contains(end)) {
                    if(end == n) return true;
                    visited.add(end);
                    q.add(end);
                }

            }
        }
        return false;

    }
}
