class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st  = new Stack<>();
        int maxarea = 0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int ele = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty()?-1:st.peek();
                maxarea = Math.max(maxarea, ele * (nse - pse - 1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ele = heights[st.pop()];
            int nse = heights.length;
            int pse = st.isEmpty()?-1:st.peek();
            maxarea = Math.max(maxarea, ele * (nse - pse - 1));
        }
        return maxarea;
    }
}