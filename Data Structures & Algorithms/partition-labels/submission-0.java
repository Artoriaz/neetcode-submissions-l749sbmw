class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> indiceMap = new HashMap<>();

        char[] chArr = s.toCharArray();
        
        for(int i = 0; i  < s.length(); i++) {
            // put it in if not there, update if already there.
            indiceMap.put(chArr[i], i);

        }
        int right = 0;
        int startPartition = 0;
        for(int left = 0; left < s.length(); left++) {
            right = Math.max(right , indiceMap.get(chArr[left]));
            if(left == right) {
                ans.add(right - startPartition +1);
                startPartition =right +1;
            }
        }



        return ans;
    }
}
