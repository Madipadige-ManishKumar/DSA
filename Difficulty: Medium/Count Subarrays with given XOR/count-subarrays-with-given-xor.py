class Solution:
    def subarrayXor(self, A, K):
        mpp = {0: 1}
        xr = 0
        cnt = 0
        for x in A:
            xr = xr ^ x
            # Calculate Y such that Y ^ K = xr
            y = xr ^ K
            if y in mpp:
                cnt += mpp[y]
            mpp[xr] = mpp.get(xr, 0) + 1
        return cnt
            # code here