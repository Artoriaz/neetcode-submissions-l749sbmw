class Solution {
    public boolean isValid(String s) {
         Map<Character, Character> map = new HashMap<>();
         map.put('{', '}');
         map.put('(', ')');
         map.put('[', ']');

         Stack<Character> pipe = new Stack<>();

         for(char c: s.toCharArray()) {
            if(map.containsKey(c)) {
                pipe.push(c);
            } else {
                if(pipe.empty()) {
                    return false;
                }

                char prevChar = pipe.pop();
                if(map.get(prevChar) != c) {
                    return false;
                }
            }
         }
         return pipe.isEmpty();
    }
}
