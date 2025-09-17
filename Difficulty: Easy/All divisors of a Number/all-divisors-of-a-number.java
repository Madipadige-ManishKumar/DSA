class Solution {
    public static void print_divisors(int n) {
        

        ArrayList<Integer> arr = new ArrayList<>();
        // code here
        for(int i=1;(i*i)<=n;i++)
        {
            if((n%i)==0)
            {
                System.out.print(i+" ");
                if(i!=(n/i))
                arr.add(0,n/i);
                // System.out.print((n/i));
            }
        }
        for(int i =0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+" ");
        }
    }
}
