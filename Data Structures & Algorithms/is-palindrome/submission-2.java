class Solution {
    public boolean isPalindrome(String s) {
      char[] answer = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
      int right = answer.length-1;
      int left =0 ;

      while(left < right ){
        if(answer[left] != answer[right]) {
            return false;
        }
        left++;
        right--;
      }
      return true;
    }
}
