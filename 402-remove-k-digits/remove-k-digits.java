class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<nums.length();i++){
            char c = nums.charAt(i);
            while(st.isEmpty()==false && k>0 && (st.peek()>c)){
                st.pop();
                k=k-1;
            }
            st.push(c);
        }
        while ( k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty()==true)
        return "0";
        StringBuilder res = new StringBuilder();
        while(st.isEmpty()==false){
            res.append(st.peek());
            st.pop();
        }
        while(res.length()!=0 && res.charAt(res.length()-1)== '0')
        res.deleteCharAt(res.length()-1);
       res.reverse();
        if(res.length() == 0) return "0";
        return res.toString();
    }
}