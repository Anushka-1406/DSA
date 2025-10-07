class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int size;
    public MyStack() {
       q1  = new LinkedList<>();
        q2 = new LinkedList<>();
        size =0;
        
    }
    
    public void push(int x) {
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        size++;
    }
    
    public int pop() {
        if(q1.isEmpty()){
            return -1;
        }
        size--;
        return q1.remove();
    }
    
    public int top() {
        if(q1.isEmpty()){
            return -1;
        }
        return q1.peek();
    }
    
    public boolean empty() {
        if(q1.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */