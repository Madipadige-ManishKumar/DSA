class Solution {
    private boolean isPalindrome(String s, int start, int end) {
        // Loop while start is less than end
        while (start < end) {
            // If characters at start and end are not equal, it's not a palindrome
            if (s.charAt(start) != s.charAt(end)) return false;
            // Move start forward and end backward
            start++;
            end--;
        }
        // If all characters matched, it's a palindrome
        return true;
    }
    public void  findsubseq(int index,List<List<String>> res,List<String> path,String s)
    {
        if(index ==s.length())
        {
            res.add(new ArrayList(path));
            return ;
        }
        for(int i =index ;i<s.length();i++)
        {
            if(this.isPalindrome(s,index,i))
            {
                path.add(s.substring(index, i + 1));
                this.findsubseq(i+1,res,path,s);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>  res = new ArrayList<>();    
        List<String>   path  = new ArrayList<>();
        this.findsubseq(0,res,path,s);
        return res;
    }
}