from typing import Optional

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        mp = dict()
        while head:
            if head in mp:
                return True
            mp[head] = True
            head = head.next
        return False

print(Solution().hasCycle(ListNode(3, ListNode(2, ListNode(0, ListNode(-4))))))