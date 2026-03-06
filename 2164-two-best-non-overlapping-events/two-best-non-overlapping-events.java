class Solution {
    public int maxTwoEvents(int[][] events) {

        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));

        int n = events.length;

        int[] suffixMax = new int[n];
        suffixMax[n-1] = events[n-1][2];

        for(int i=n-2;i>=0;i--)
            suffixMax[i] = Math.max(events[i][2], suffixMax[i+1]);

        int ans = 0;

        for(int i=0;i<n;i++)
        {
            int end = events[i][1];

            int l=i+1,r=n-1,pos=n;

            while(l<=r)
            {
                int mid = (l+r)/2;

                if(events[mid][0] > end)
                {
                    pos = mid;
                    r = mid-1;
                }
                else
                    l = mid+1;
            }

            int value = events[i][2];

            if(pos<n)
                value += suffixMax[pos];

            ans = Math.max(ans,value);
        }
        return ans;
    }
}