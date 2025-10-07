class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int sum =0;
        for(int i=0;i<operations.length;i++){
            if(!st.isEmpty() && operations[i].equals("C")){
                st.pop();
            }
            else if(operations[i].equals("D")){
                st.push(st.peek()*2);
            }
            else if(operations[i].equals("+") && st.size()>=2){
                int top = st.get(st.size()-1);
                int prev = st.get(st.size()-2);
                st.push(top+prev);
            }
            else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        while(!st.isEmpty()){
        sum+=st.pop();
        }
        return sum;
    }
}