class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> st = new Stack<>();
        int idx = 0;
        for(int i =0;i<word.length();i++)
        {
            st.push(word.charAt(i));
            if(ch == word.charAt(i)){
                idx = i;
                
                break;
            }
        }
        if(idx!=0){
            StringBuffer res = new StringBuffer();
            while(!st.empty())
            {
                res.append(st.peek());
                st.pop();
            }
            for(int i=idx+1;i<word.length();i++)
            {
                res.append(word.charAt(i));
            }

            return res.toString();
        }
        return word;
    }
}