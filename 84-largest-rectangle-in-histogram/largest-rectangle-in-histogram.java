class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int maxno = 0;
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                int ele = arr[st.pop()];
                int nse = i;
                int pse = st.isEmpty()?-1:st.peek();
                maxno = Math.max(maxno,ele*(nse-pse-1));  
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ele = arr[st.pop()];
           int  nse = arr.length;
            int pse = st.isEmpty()?-1:st.peek();
            maxno = Math.max(maxno,ele*(nse-pse-1)); 
        }
        return maxno;
    }
}