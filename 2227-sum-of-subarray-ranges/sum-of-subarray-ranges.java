class Solution{
private int[] prevSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] psee = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    private int[] nextSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] prevGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pge = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }

    private int[] nextGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    public long subArrayRanges(int[] arr) {
        int n = arr.length;

        int[] nse = nextSmaller(arr);
        int[] psee = prevSmaller(arr);
        int[] pge = prevGreater(arr);
        int[] nge = nextGreater(arr);

        long sumMax = 0;
        long sumMin = 0;

        for (int i = 0; i < n; i++) {
            long leftSmall = i - psee[i];
            long rightSmall = nse[i] - i;
            long leftGreat = i - pge[i];
            long rightGreat = nge[i] - i;

            sumMin += arr[i] * leftSmall * rightSmall;
            sumMax += arr[i] * leftGreat * rightGreat;
        }

        return sumMax - sumMin;
    }
}