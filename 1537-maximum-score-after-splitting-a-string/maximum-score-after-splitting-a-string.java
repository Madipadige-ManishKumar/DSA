class Solution {
    public int maxScore(String s) {
        int zeros =0;
        int ones =0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            zeros++;
            else
            ones++;
        }
        int left_score=0;
        int right_score=0;
        int total_score =-1;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='0')
            {
                left_score++;
            }
            else
            {
                ones--;
            }
            total_score = Math.max(total_score,left_score+ones);
        }
        return total_score;
    }
}