class Solution {
    public int maxArea(int[] height) {
      int maxarea = 0;
      int left = 0;
      int right = height.length-1;
      for(int i =0; i<height.length;i++){
        int minele = Math.min(height[left],height[right]);
        int area = minele*(right - left);
        maxarea = Math.max(area,maxarea);
        if(height[left] < height[right]){
            left++;
        }
        else{
            right--;
        }
      }
      return maxarea;  
    }
}