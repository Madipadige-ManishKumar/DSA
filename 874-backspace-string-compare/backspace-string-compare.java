class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        Stack<Character> st1 = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(!st.empty() && s.charAt(i)=='#'){
            st.pop();
            continue;
            }
            if(!(s.charAt(i)=='#'))
            st.push(s.charAt(i));
        }
        /*
f
f

        */
        for(int i=0;i<t.length();i++)
        {
            if(!st1.empty() && t.charAt(i)=='#'){
            st1.pop();
            continue;
            }
            if(!(t.charAt(i)=='#'))
            st1.push(t.charAt(i));
        }
        while(!st.empty() && !st1.empty())
        {
            if(st.peek() != st1.peek())
            return false;
            st.pop();
            st1.pop();
        }
        return (st.empty() && st1.empty());
  
    }
}