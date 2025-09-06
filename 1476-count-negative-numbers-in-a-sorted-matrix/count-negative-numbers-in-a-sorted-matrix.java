class Solution {
    public int countNegatives(int[][] arr) {
        int count=0;
        for(int i =0;i<arr.length;i++)
        {
            for(int j =0;j<arr[i].length;j++)
            {
                if(arr[i][j]<0)
                {
                    count +=(arr[i].length-j);
                    break;
                }
            }
        }
        return count;
    }
}