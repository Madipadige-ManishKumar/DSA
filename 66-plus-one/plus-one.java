class Solution {
    public int[] plusOne(int[] digits) {
        String s="";
        int i,n,j=0,f=0;
        for (i=digits.length-1;i>=0;i--)
        {
            digits[i]+=1;            
            if(digits[0]>9)
            f=1;
            if(digits[i]>9)
            {
                digits[i]=0; 
            }
            else
            {
                break;
            }

        }
        int [] arr=new int[digits.length];
        if(f==1)
        {
                arr= new int[digits.length+1];
                
                arr[j]=1;
                j++;
                for(i=0;j<arr.length && i<digits.length;j++,i++)
                {
                    arr[j]=digits[i];
                }
                return arr;
        }
        else
        {
            return digits;
            
        }
        // System.out.println("the length is "+arr.length);
        // System.out.println("The J is "+j);


        // return arr;
    }
}