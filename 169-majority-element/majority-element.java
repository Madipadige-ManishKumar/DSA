import java.util.HashMap;
import java.util.Map;
class Solution {
    public int majorityElement(int[] nums) {
        int can=nums[0],count=1,i=1;
        while(i<nums.length)
        {
            
            if(count==0)
            {
                can=nums[i];
                count=1;
            }
            else{
            if(can==nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
            }
            i++;
        }
        return can;
    }
}