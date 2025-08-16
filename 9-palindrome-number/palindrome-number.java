class Solution {
    public boolean isPalindrome(int x) {
    int t=x;
    int r=0;
    while(t>0)
    {
        r=r*10+t%10;
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
 