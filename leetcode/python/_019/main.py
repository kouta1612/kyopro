from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = first = second = ListNode(0, head)
        for _ in range(n + 1):
            second = second.next
        while second:
            first = first.next
            second = second.next
        first.next = first.next.next
        return dummy.next

print(Solution().removeNthFromEnd(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), 2))