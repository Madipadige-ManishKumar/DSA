class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five,ten,tw;
        five=ten=tw=0;
        for(int i=0;i<bills.length;i++)
        {   
            if(bills[i]==5)
            {
                five++;
            }
            else if (bills[i]==10)
            {
                if(five>0)
                five--;
                else
                return false;
                ten++;
            }
            else if(bills[i]==20)
            {
                if(five>0 && ten>0)
                {
                    five--;
                    ten--;
                }
                else if (five>=3)
                five-=3;
                else
                return false;
                tw++;
            }
        }
        return true;
    }
}