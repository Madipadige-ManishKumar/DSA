class Solution {
    public boolean isPalindrome(String s) {
        
        // String s1="abcdefghijklmnopqrstuvwxyz";
        // String s2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // for() 
        // 65 90 97 12        
        int a=0;
        String s1="";
        String s2="";
        for(int i=0;i<s.length();i++)
        {
            a=(int)s.charAt(i);
            // //System.out.println("The Charcter is "+s.charAt(i)+"The integer value  is "+a);
            if((a>=65&&a<=90)||(a>=97&&a<=122)||(a>=48&&a<=57))
            s2+=s.charAt(i);
        }
        for(int i=s.length()-1;i>=0;i--)
        {
            a=(int)s.charAt(i);
            //System.out.println("The Charcter is "+s.charAt(i)+"The integer value  is "+a);
            if((a>=65&&a<=90)||(a>=97&&a<=122)||(a>=48&&a<=57))
            s1+=s.charAt(i);
        }
        //System.out.println("The s1 is "+s1);
        //System.out.println("The s2 is"+s2);
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        if(s1.equals(s2))
        return true;
        else
        return false;
    // return false;
    }
}