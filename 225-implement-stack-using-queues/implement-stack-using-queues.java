class MyStack {
    ArrayList<Integer>  q1;
    ArrayList <Integer> q2;
    public MyStack() {
        
        q1 = new ArrayList<Integer>();
        q2 = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        q2.add(x);
        while(q1.size() !=0)
        {
            q2.add(q1.get(0));
            q1.remove(0);
        }
        ArrayList <Integer> t = q1;
        q1=q2;
        q2=t;

        
    }
    
    public int pop() {
        int n = q1.get(0);
        q1.remove(0);
        return n;
    }
    
    public int top() {
        return q1.get(0);
    }
    
    public boolean empty() {
        return this.q1.size()==0;
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