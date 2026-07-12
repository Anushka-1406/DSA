class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalsum =0;
        int currentmax = 0;
        int maxsum = nums[0];
        int currentmin = 0;
        int minsum = nums[0];
        for(int num : nums){
            totalsum += num;

            currentmax = Math.max(num, currentmax+num);
            maxsum = Math.max(maxsum,currentmax);

            currentmin = Math.min(num,currentmin+num);
            minsum = Math.min(minsum,currentmin);

            
        }
        if(totalsum == minsum){
                return maxsum;
            }
        return Math.max(maxsum,totalsum-minsum);
    }
}