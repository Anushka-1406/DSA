class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length-2;
        while(pivot>=0 && nums[pivot] >= nums[pivot + 1]){
            pivot--;
        }
        if(pivot != -1){
            int rightmostsuccessor = nums.length-1;
            while(nums[rightmostsuccessor] <= nums[pivot]){
                rightmostsuccessor--;
            }
            int temp = nums[pivot];
            nums[pivot] = nums[rightmostsuccessor];
            nums[rightmostsuccessor] = temp;
        }
        reverse(nums,pivot+1,nums.length-1);
    }
    private static void reverse(int[] nums,int left,int right){
        while(left<right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left ++;
        right --;
        }
    }
}