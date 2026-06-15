class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] hash = new int[256];
        for(int i=0;i<m ; i++){
            hash[t.charAt(i)]++;
        }
        int left = 0,right = 0, count = 0, minlen = Integer.MAX_VALUE,startindex = -1;
        while(right < n){
            if(hash[s.charAt(right)] > 0){
                count++;
            }
            hash[s.charAt(right)]--;
            while(count == m){
                if(right - left + 1 < minlen){
                    minlen = right - left + 1;
                    startindex = left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0){
                    count--;
                }
                left++;
            }
            right++;
        }
            if(startindex == -1){
                return "";
            }
            else{
                return s.substring(startindex, startindex+minlen);
            }
    }
}