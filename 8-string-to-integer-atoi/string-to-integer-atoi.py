class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        n=len(s)
        i, res, sign = 0, 0, 1
        # 1. Skip Whitespace
        while i < n and s[i] == ' ': i += 1
        # 2. Check Sign
        if i < n and s[i] in '+-':
            sign = -1 if s[i] == '-' else 1
            i += 1
        # 3. Convert Digits
        while i < n and s[i].isdigit():
            res = res * 10 + int(s[i])
            i += 1
        # 4. Clamp Result
        return max(-2**31, min(res*sign, 2**31-1))