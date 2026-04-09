class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++)
        {
            if(!st.empty() && st.peek() == s.charAt(i))
            {
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        StringBuilder  res = new StringBuilder("");
        while(!st.empty())
        {
            res.insert(0,st.pop());
        }
        return res.toString();
    }
}