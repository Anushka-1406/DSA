class Solution {
    public boolean isPalindrome(int x) {
    int t=x;
    int r=0;
    while(t>0)
    {
        int ld=t%10;
        r=r*10+ld;
        t=t/10;
    }  
    if(r==x)
    {
        return true;
    }
    else
    {
        return false;
    }
    }
}
 