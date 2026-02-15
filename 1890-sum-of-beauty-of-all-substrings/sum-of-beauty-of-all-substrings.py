class Solution(object):
    def beautySum(self, s):
        """
        :type s: str
        :rtype: int
        """
        n=len(s)
        total=0
        for i in range(n):
            freq = {}
            for j in range(i, n):
                char = s[j]
                freq[char] = freq.get(char, 0) + 1
                
                mx = max(freq.values())
                mn = min(freq.values())
                total += (mx - mn)
        return total