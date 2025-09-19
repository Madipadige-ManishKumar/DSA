import java.util.ArrayList;

class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> min_stack;

    public MinStack() {
        stack = new ArrayList<>();
        min_stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if (min_stack.isEmpty() || val <= min_stack.get(min_stack.size() - 1)) {
            min_stack.add(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int removed = stack.remove(stack.size() - 1);
        if (removed == min_stack.get(min_stack.size() - 1)) {
            min_stack.remove(min_stack.size() - 1);
        }
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return min_stack.get(min_stack.size() - 1);
    }
}
