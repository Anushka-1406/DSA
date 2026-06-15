class Solution {
    public boolean isPalindrome(int x) {
        int revnum = 0;
        int dup = x;
        while(x > 0){
            // int ld = x % 10;
            revnum = (revnum * 10) + x % 10;
            x = x/10;
        }
        return dup == revnum;
    }
}