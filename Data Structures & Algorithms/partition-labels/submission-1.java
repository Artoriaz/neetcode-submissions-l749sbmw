class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> indiceMap = new HashMap<>();

        List<Integer> ans = new ArrayList<>();
        char[] chArr = s.toCharArray();

        for(int i = 0; i< s.length(); i++) {
            indiceMap.put(chArr[i], i);
        }

        int size = 0;
        int window =0;
        for(int i= 0 ; i < s.length(); i++) {
            size++;
            window = Math.max(window, indiceMap.get(chArr[i]));
            if(i == window) {
                ans.add(size);
                size = 0;
            }

        }

        return ans;
    }
}
