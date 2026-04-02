class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charr = s.toCharArray();

        int left = 0;
        int right = charr.length - 1;

        while (left < right) {
            if (charr[left] != charr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}