class MyStack {
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top;
    public MyStack() {

    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        while(q.size()!=1) {
            q2.offer(q.poll());
        }

        int cur = q.poll();

        while(!q2.isEmpty()) {
            q.offer(q2.poll());
        }
        return cur;
    }
    
    public int top() {
        while(q.size()!=1) {
            q2.offer(q.poll());
        }

        int cur = q.poll();
        q2.offer(cur);
        while(!q2.isEmpty()) {
            q.offer(q2.poll());
        }
        return cur;
    }
    
    public boolean empty() {
        return q.isEmpty();
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