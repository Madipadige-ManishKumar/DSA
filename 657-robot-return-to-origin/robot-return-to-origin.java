class Solution {
    public boolean judgeCircle(String s) {
        int [] pos ={0,0};
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='U')
            {
                pos[0]+=1;
            }
            else if(s.charAt(i) == 'D')
            pos[0]-=1;
            else if(s.charAt(i)=='L')
            pos[1]-=1;
            else if(s.charAt(i)=='R')
            pos[1]+=1;
        }
        return pos[0]==0 && pos[1]==0;
    }
}