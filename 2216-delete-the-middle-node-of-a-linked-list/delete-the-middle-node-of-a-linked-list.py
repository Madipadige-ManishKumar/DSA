# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteMiddle(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """

        temp = head
        l=0
        while temp:
            l+=1
            temp=temp.next
        if l==1:
            return None
        elif l==2:
            head.next=None

        else:            
            mid=int(l/2)
            temp = head
            c=0
            while temp:
                if(c+1==mid):
                    temp.next=temp.next.next
                    break
                c+=1
                temp=temp.next
        return head

        