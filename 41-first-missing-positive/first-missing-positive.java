class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] filterednums = Arrays.stream(nums).filter(n -> n>0).toArray();

        Arrays.sort(filterednums);
        int target = 1;
        for(int n : filterednums){
            if(target == n){
                target++;
            } else if(n > target){
                return target;
            }
        }
        return target;
    }
}