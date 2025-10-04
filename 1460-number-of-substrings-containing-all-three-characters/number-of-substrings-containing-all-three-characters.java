class Solution {
    public int numberOfSubstrings(String s) {
        int freq []= {-1,-1,-1};
        int res=0;
        for(int r =0;r<s.length();r++)
        {
            freq[s.charAt(r)-'a']=r;
            if((freq[0]!= -1)  && (freq[1]!= -1) && (freq[2]!= -1))
            {
                res+=1+Math.min(Math.min(freq[0],freq[1]),freq[2]);
            }
        }
        return res;
    }
}