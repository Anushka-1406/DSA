class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a =nums[i];
            int more = target-a;
            if(mpp.containsKey(more)){
                return new int[]{i,mpp.get(more)};
            }
            mpp.put(a,i);
        }
        return new int[]{};
    }
}