class Solution {
    public static int[] prevsmallele(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] psee = new int[n];
        for(int i=0;i<n;i++){
            while(st.isEmpty() == false && arr[st.peek()]>arr[i]){
                st.pop();
            }
            psee[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return psee;
    }
    public static int[] nextsmallele(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for(int i=n-1;i>=0;i--){
            while(st.isEmpty() == false && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public static int sumSubarrayMins(int arr[]){
        int n = arr.length;
       int[] nse = nextsmallele(arr);
        int[] psee = prevsmallele(arr);
        long total = 0;
        int mod = (int)(1e9+7);
        for(int i=0;i<n;i++){
            int left = i-psee[i];
            int right = nse[i] - i;
            total = (total + (right*left*1L*arr[i])%mod)%mod;
        }
        return (int)(total%mod);
    }
}