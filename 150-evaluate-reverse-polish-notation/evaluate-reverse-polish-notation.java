class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int sum =0;
        for(int i=0;i<tokens.length;i++){
            if(!st.isEmpty() && tokens[i].equals("+")&& st.size()>=2){
                int top = st.pop();
            int prev = st.pop();
               st.push(top+prev);  
            }
            else if(tokens[i].equals("/")&& st.size()>=2){
                int top = st.pop();
            int prev = st.pop();
                st.push(prev/top);
            }
            else if(tokens[i].equals("-")&& st.size()>=2){
                int top = st.pop();
            int prev = st.pop();
                st.push(prev-top);
            }
            else if(tokens[i].equals("*")&& st.size()>=2){
                int top = st.pop();
            int prev = st.pop();
                st.push(prev*top);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        while(!st.isEmpty()){
            sum = st.pop();
        }
        return sum;
    }
}