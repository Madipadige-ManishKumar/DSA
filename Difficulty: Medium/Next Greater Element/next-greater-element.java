class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.empty() && st.peek()<=arr[i])
            st.pop();
            if(st.empty())
            res.add(0,-1);
            else
            res.add(0,st.peek());
            
            st.push(arr[i]);
        }
        return res;
    }
}