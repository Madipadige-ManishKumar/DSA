class Solution {
    public boolean validateparen(StringBuffer sb)
    {
        int count=0;
        for(int i=0;i<sb.length();i++)
        {
            if(sb.charAt(i)=='(')
            count++;
            else if (sb.charAt(i)==')')
            count--;
            if (count<0)
            return false;
        }
        return count==0;
    }
    public void findsubseq(int index,int n,StringBuffer sb,List<String> res)
    {
        if(index==(n*2))
        {
            if(this.validateparen(sb))
            {
                res.add(sb.toString());
            }
            return;
        }
        sb.append("(");
        this.findsubseq(index+1, n, sb,res);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        this.findsubseq(index+1,n,sb,res);
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        StringBuffer sb = new StringBuffer("");
        List <String>  res = new ArrayList<>();
        this.findsubseq(0,n,sb,res);
        return res;
    }
}