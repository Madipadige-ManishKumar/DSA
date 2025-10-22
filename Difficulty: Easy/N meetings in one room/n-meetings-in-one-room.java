import java.util.*;
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        List<int[]> meetings = new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
            meetings.add(new int[]{end[i],start[i],i+1});
        }
        Collections.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        
        int count=0;
        int freetime=-1;
        for(int[] arr :meetings)
        {
            if(arr[1]>freetime)
            {
                count++;
                freetime=arr[0];
            }
        }
        return count;
    }
}
