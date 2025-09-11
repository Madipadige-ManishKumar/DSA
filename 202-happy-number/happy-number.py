class Solution(object):
    def happycheck(self, seen, n):
        if n == 1:
            return True
        elif n in seen:
            return False
        else:
            seen.add(n)
            total = 0
            while n > 0:
                digit = n % 10
                total += digit * digit
                n //= 10
            return self.happycheck(seen, total)

    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return self.happycheck(set(), n)

