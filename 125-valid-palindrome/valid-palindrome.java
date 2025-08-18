class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        return isPalindromeHelper(0,s.length()-1,s);
    }
    private boolean isPalindromeHelper(int left,int right,String s){
       if(left>=right)
       return true;;
       if(s.charAt(left)!=s.charAt(right))
       return false;
       return isPalindromeHelper(left+1,right-1,s);
    }
}