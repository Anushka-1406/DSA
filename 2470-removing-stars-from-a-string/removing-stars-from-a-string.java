class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && ch=='*'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
    while(!st.isEmpty()){
     sb.append(st.pop());
    }
    return sb.reverse().toString();
    }
}