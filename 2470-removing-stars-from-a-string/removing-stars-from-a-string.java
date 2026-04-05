class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            if(!st.empty() && s.charAt(i)=='*')
            {
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        StringBuffer res  = new StringBuffer();
        while(!st.empty())
        {
            res.insert(0,st.peek());
            st.pop();
        }
        return res.toString();
    }
}