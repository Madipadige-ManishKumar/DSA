class Solution(object):
    def happycheck(self,arr,n):
        if int(n) ==1:
            return True
        elif n in arr:
            return False
        sum=0
        for i in str(n):
            i=int(i)
            sum+=(i*i)
        arr.append(n)
        return self.happycheck(arr,sum)
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return self.happycheck([],str(n))