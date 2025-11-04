from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        first, second = head, head.next
        while second and second.next:
            first, second = first.next, second.next.next
        tmp = first.next
        first.next = None
        first, second = head, tmp

        pre = None
        while second:
            tmp = second.next
            second.next = pre
            pre, second = second, tmp
        second = pre

        while first and second:
            tmp, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp
            first, second = tmp, tmp2

print(Solution().reorderList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))))