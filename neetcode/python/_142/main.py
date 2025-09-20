from typing import Optional

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None

        slow = fast = head
        while True:
            if not fast.next or not fast.next.next:
                return None
            slow, fast = slow.next, fast.next.next
            if slow == fast:
                break
        fast = head
        while fast != slow:
            slow, fast = slow.next, fast.next
        return slow

print(Solution().detectCycle(ListNode(3, ListNode(2, ListNode(0, ListNode(-4))))))