class Solution {
    List<List<String>> answer;
    List<String> part = new ArrayList<>();
    char[] word;
    public List<List<String>> partition(String s) {
        word = s.toCharArray();
        answer = new ArrayList<>();

        backtracking(0, 0, s );

        return answer;
    }

    public void backtracking(int j, int i, String s) {
        if( i >= s.length()) {
            if (i == j) {
                answer.add(new ArrayList<>(part));
            }
            return;
        }
        if(isPalindrome(s.toCharArray(), j, i)) {
            part.add(s.substring(j, i +1));
            backtracking(i +1 , i +1, s);
            part.remove(part.size()-1);
        }
        backtracking(j, i + 1, s);
    }

    public boolean isPalindrome(char[] word,int left, int right) {
        while(left < right) {
            if(word[left] != word[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
