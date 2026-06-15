class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String , List<String>> mpp = new HashMap<>();
        for(String words : strs){
            char[] chars = words.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!mpp.containsKey(key)){
                mpp.put(key, new ArrayList<>());
            }
            mpp.get(key).add(words);
        }
        return new ArrayList<>(mpp.values());
    }
}