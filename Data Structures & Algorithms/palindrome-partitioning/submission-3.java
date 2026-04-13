class Solution {
    List<List<String>> answer;
    public List<List<String>> partition(String s) {
        List<String> part = new ArrayList<>();
        answer = new ArrayList<>();
        dfs(0, s, part);
        return answer;
        
    }
    public void dfs(int i, String s, List<String> part) {
        if(i >= s.length()) {
            answer.add(new ArrayList<>(part));
            return;
        }
        for(int j =i ; j < s.length(); j++) {
            if(isPali(s,i, j)){
                part.add(s.substring(i, j +1));
                dfs(j+1,s , part);
                part.remove(part.size() -1);
            }
        }
    }
     private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
