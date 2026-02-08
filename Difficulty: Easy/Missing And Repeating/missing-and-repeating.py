class Solution:
    def findTwoElement(self, arr):
        # code here
        n = len(arr)
    # Using Frequency Array
        freq = [0] * (n + 1)
        for x in arr:
            freq[x] += 1
        
        rep, miss = -1, -1
        for i in range(1, n + 1):
            if freq[i] == 2: rep = i
            if freq[i] == 0: miss = i
        return rep, miss

