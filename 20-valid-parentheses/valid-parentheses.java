class Solution {
    public boolean isValid(String s) {
        String st[] = new String[s.length()];
        int i=0,t=-1;    
        String s3;
        if (s.length()==1)
        {
            return false;
        }
        for(i=0;i<s.length();i++)
        {
            
            
            String s2=String.valueOf(s.charAt(i));
            if(s2.equals("(") || s2.equals("{") ||s2.equals("[") )
            {
                
                t++;
                st[t]=String.valueOf(s.charAt(i));
                
            }
            else if(s2.equals(")"))
            {
                
                if(t!=-1){
                if(st[t].equals("("))
                {
                    t--;
                }
                else
                {
                    return false;
                }
                }
            else
            return false;
            }
            else if(s2.equals("]"))
            {
                
                if(t!=-1){
                    
                if(st[t].equals("["))
                {
                    t--;
                }
                else
                {
                    return false;
                }
                }
                else
                {
                    return false;
                }
            }
            else if(s2.equals("}"))
            {
                
                if(t!=-1)
                {

                
                if(st[t].equals("{"))
                {
                    t--;
                }
                else
                {
                    return false;
                }
                }
                else
                return false;
            }
            
        }
        
        if(t==-1)
        return true;
        else
        return false;
    }
}