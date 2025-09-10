from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        copy = head
        while head.next:
            pre, tail = None, head
            while tail.next:
                pre = tail
                tail = tail.next
            if head.next is tail:
                head = copy
                return
            tmp = head.next
            head.next = tail
            tail.next = tmp
            pre.next = None
            head = tmp

print(Solution().reorderList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))))