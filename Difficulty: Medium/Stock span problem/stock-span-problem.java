class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++)
        {
            while((!st.empty()) && arr[st.peek()] <= arr[i])
            {
                st.pop();
            }
            
            
            if(st.empty())
            res[i]=-1;
            else
            res[i]=st.peek();
            
            st.push(i);
        }
        
        ArrayList<Integer> span = new ArrayList<>();
        for(int i =0;i<res.length;i++)
        {
            if(res[i] == -1)
            {
                span.add(i+1);
            }
            else
            {
                span.add(i-res[i]);
            }
        }
        
        return span;
    }
}