class Solution {
    public int reverse(int x) {
        long result=0;
        while(x!=0){
        long lastdigit=x%10;
        result=result*10+lastdigit;
        x/=10;
        }
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return 0;
        }
        else{
            return (int)result;
        }
    }
}