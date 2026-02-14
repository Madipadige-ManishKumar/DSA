class Solution {
    static boolean func(int[] arr, int sum, int curr, int index, int n) {

        if (curr == sum) return true;
        if (index >= n || curr > sum) return false;

        
        if (func(arr, sum, curr + arr[index], index + 1, n))
            return true;

        
        return func(arr, sum, curr, index + 1, n);
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        return func(arr, sum, 0, 0, arr.length);
    }
}
