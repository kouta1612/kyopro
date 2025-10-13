from typing import Optional

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
            if slow == fast: return True
        else: return False

print(Solution().hasCycle(ListNode(3, ListNode(2, ListNode(0, ListNode(-4))))))
