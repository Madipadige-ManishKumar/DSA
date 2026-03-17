# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def list_sort(self,head1):
        cur11=head1
        l=[]
        while cur11:
            l.append(cur11.val)
            cur11=cur11.next
        i=0
        l=sorted(l)
        cur11=head1
        while cur11:
            cur11.val=l[i]
            cur11=cur11.next
            if(i<len(l)):
                i=i+1
        cur11=head1

        return head1
    
    def mergeTwoLists(self, head1, head2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        obj1=Solution()
        head3=ListNode()
        cur1=head1
        cur2=head2
        if cur1 !=None and cur2!=None:
            while cur1.next:
                cur1=cur1.next
            cur1.next=cur2
            cur1=head1
            cur1=obj1.list_sort(cur1)
        elif cur1==None and cur2 !=None:
            cur1=obj1.list_sort(cur2)
        elif cur1!=None and cur2 ==None:
            cur1=obj1.list_sort(cur1)
        elif cur1==None and cur2==None: 
            return cur1
        return cur1