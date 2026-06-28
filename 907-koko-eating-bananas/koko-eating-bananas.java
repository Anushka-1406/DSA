class Solution {
    private long calculateTotalhours(int[] piles , int speed){
        long totalH = 0;
        for(int bananas : piles){
            totalH += (int)Math.ceil((double)bananas / speed);
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxpile = Arrays.stream(piles).max().getAsInt();

        int low = 1 , high = maxpile;
        int ans = maxpile;
        while(low <= high){
            int mid = (low + high)/2;
            long totalH = calculateTotalhours(piles , mid);

            if(totalH <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}