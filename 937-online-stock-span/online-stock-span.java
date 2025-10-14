class StockSpanner {
    Stack<int[]> st = new Stack<>();
    int ind = -1;
    public StockSpanner() {
        st.clear();
    }

    public int next(int val) {
        ind++;
        while (!st.isEmpty() && st.peek()[0] <= val)
            st.pop();

        int ans = ind - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[]{val, ind});
        return ans;
    }
}