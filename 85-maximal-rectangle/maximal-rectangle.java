class Solution {
    public static int largestrectangle(int[] arr){
        Stack<Integer> st = new Stack<>();
        int maxarea = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            while(st.isEmpty()==false && arr[st.peek()]>=arr[i]){
                int element = arr[st.pop()];
                int nse = i;
                int pse = st.isEmpty()?-1:st.peek();
                maxarea = Math.max(maxarea,element*(nse-pse-1));
            }
            st.push(i);
        }
        while(st.isEmpty()==false){
            int nse =n;
            int element = arr[st.pop()];
            int pse = st.isEmpty()?-1:st.peek();
            maxarea = Math.max(maxarea, (nse-pse-1)*element);
        }
        return maxarea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxarea =0;
        int[][] psum = new int[n][m];
        for(int j=0;j<m;j++){
            int sum =0;
            for(int i=0;i<n;i++){
                int val = matrix[i][j]-'0';
                sum+=val;
                if(val==0){
                    sum=0;
                }
                psum[i][j] = sum;
            }
        }
        for(int i=0;i<n;i++){
            maxarea = Math.max(maxarea,largestrectangle(psum[i]));
        }
        return maxarea;
    }
}