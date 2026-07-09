class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int hashlen = 256;
        int[] hash = new int[hashlen];
        Arrays.fill(hash,-1);
        int l = 0 , r = 0, maxlen = 0;
        while(r < n){
            if(hash[s.charAt(r)] >= l){
                l = Math.max(hash[s.charAt(r)]+1 , l);

            }
            int len = r-l + 1;
            maxlen = Math.max(maxlen,len);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxlen;

    }
}