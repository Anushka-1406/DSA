class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            int odd = expand(s,i,i);
            int even = expand(s,i,i+1);
            int maxlen = Math.max(odd, even);

            if(maxlen > end - start  + 1){
                start = i - (maxlen-1)/2;
                end = i + maxlen/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int expand(String s, int left, int right){
        int count =0;
        while( left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }
}