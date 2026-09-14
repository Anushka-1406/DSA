class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l=0,r=0,maxfreq=0,maxlen=0;
        while(r <  s.length()){
            freq[s.charAt(r) - 'A']++;
            maxfreq = Math.max(maxfreq,freq[s.charAt(r)-'A']);
            if((r-l+1)-maxfreq > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}