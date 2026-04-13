class Solution {
    Map<Integer, List<Character>> dial;
    List<String> answer;
    public List<String> letterCombinations(String digits) {
        dial = new HashMap<>();
        answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;
        dial.put(2, Arrays.asList('a', 'b', 'c'));
        dial.put(3, Arrays.asList('d', 'e', 'f'));
        dial.put(4, Arrays.asList('g', 'h', 'i'));
        dial.put(5, Arrays.asList('j', 'k', 'l'));
        dial.put(6, Arrays.asList('m', 'n', 'o'));
        dial.put(7, Arrays.asList('p', 'q', 'r', 's'));
        dial.put(8, Arrays.asList('t', 'u', 'v'));
        dial.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        //edge case of 1 and 0 . what do we do.
        StringBuilder str = new StringBuilder();
        dfs(str, digits, 0);
        return answer;
    }
   public void dfs(StringBuilder str, String digits, int i) {
    
    if (i == digits.length()) {
        answer.add(str.toString());
        return;
    }
    
    int digit = digits.charAt(i) - '0';
    if (!dial.containsKey(digit)) {
        dfs(str, digits, i + 1);
        return;
    }
    
    for (char c : dial.get(digit)) {
        str.append(c);
        dfs(str, digits, i + 1);
        str.deleteCharAt(str.length() - 1);
    }
}
}
