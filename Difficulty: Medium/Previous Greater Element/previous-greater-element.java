class Solution {
    static ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            while(!st.empty() && st.peek()<=arr[i])
            {
                st.pop();
            }
            if(st.empty())
            {
                res.add(-1);
            }
            else
            {
                res.add(st.peek());
            }
            st.push(arr[i]);
        }
        return res;
    }
}