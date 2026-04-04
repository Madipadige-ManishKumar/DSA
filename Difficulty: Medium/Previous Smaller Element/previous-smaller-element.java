class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer>  res = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            while(!st.empty() && st.peek()>=arr[i]){
                st.pop();
            }
            if(st.empty())
            res.add(-1);
            else
            res.add(st.peek());
            
            st.push(arr[i]);
        }
        return res;
    }
}