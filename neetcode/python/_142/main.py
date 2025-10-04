from typing import Optional

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow, fast = head, head
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
            if slow is fast: break
        if not (fast and fast.next): return None

        slow = head
        while True:
            if slow is fast: return slow
            slow, fast = slow.next, fast.next

print(Solution().detectCycle(ListNode(3, ListNode(2, ListNode(0, ListNode(-4))))))