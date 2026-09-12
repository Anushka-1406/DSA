class Solution {
    public int maxProduct(int[] nums) {
        int pre=1;
        int suf=1;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(pre==0) pre=1;
            if(suf==0) suf=1;
            pre*=nums[i];
            suf*=nums[nums.length-1-i];
            maxi = Math.max(maxi,Math.max(pre,suf));
        }
        return maxi;
    }
}