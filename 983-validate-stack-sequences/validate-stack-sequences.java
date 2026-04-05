/*

1 2 3 4
*/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int n = pushed.length;
        int m = popped.length;
        int i=0;
        int j=0;
        while(i<n && j<m)
        {
            if(!st.empty())
            {
                if(st.peek() == popped[j])
                {
                    j++;
                    st.pop();
                    continue;
                }
            }
            st.push(pushed[i]);
            i++;
        }
        while(!st.empty() && j<m && (popped[j]==st.peek()))
        {
            st.pop();
            j++;
        }
        return (st.empty() && j>=m);
    }
}