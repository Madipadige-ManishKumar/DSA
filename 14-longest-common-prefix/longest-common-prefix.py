class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        res=""
        for j in range(len(strs[0])):
            char=strs[0][j]
            for i in range(1,len(strs)):
                if  j >=len(strs[i]) or char!=strs[i][j]:
                    return res
            res+=char
        return res
        
        