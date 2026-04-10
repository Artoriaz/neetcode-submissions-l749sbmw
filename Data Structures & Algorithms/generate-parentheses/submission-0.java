class Solution {
    List<String> answer;
    public List<String> generateParenthesis(int n) {
        StringBuilder startingString = new StringBuilder();
        answer = new ArrayList<>();
        dfs(n, startingString, 0, 0);
        return answer;
    }
    public void dfs(int n, StringBuilder sb, int open, int close) {
        if(open == n && close == n) {
            answer.add(sb.toString());
            return;
        }
        if(open < n) {
            sb.append("(");
            dfs(n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        } 
        if(close < open) {
            sb.append(")");
            dfs(n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        

        //removal
       
    
    }
}
