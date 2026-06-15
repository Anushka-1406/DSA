class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() < 1) return 0;
        int count = 0;
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            count += expand(s,i,i);
            count += expand(s,i,i+1);
        }
        return count;
    }
    private int expand(String s, int left, int right){
        int count = 0;
        while( left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}