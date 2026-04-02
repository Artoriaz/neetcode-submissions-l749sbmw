class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dic = new HashMap<>();

        for(String word: strs) {
            char[] charWord = word.toCharArray();
            Arrays.sort(charWord);
            String key = new String(charWord);
            if(!dic.containsKey(key)) {
                dic.put(key, new ArrayList<String>());
            }
            dic.get(key).add(word);
        }
        return new ArrayList(dic.values());
    }
}
