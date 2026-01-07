class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int max  =-1;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]>=max)
            {
                result.add(0,arr[i]);
                max= arr[i];
            }
        }
        return result;
    }
}
