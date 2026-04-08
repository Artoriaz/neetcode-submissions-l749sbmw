class Solution {
    public boolean checkValidString(String s) {
        char[] chArr = s.toCharArray();
        int high  =0;
        int low = 0;

        for(char c: chArr) {
            if(c == '(') {
                low++;
                high++;
            }
            if(c == ')') {
                low--;
                high--;
            }
            if(c == '*') {
                low--;
                high++;
            }

             if(high < 0) return false;
             low = Math.max(low, 0);
        }
        return low == 0;
    }
}

