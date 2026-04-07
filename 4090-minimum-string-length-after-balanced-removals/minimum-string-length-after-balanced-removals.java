class Solution {
    public int minLengthAfterRemovals(String s) {
        int a_count =0;
        int b_count =0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) =='a')
            a_count++;
            else
            b_count++;
        }
        return Math.abs(a_count-b_count);
    }
}