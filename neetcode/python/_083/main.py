from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        res = cur = head
        seen = set()
        while cur:
            seen.add(cur.val)
            nxt = cur.next
            while nxt and nxt.val in seen:
                nxt = nxt.next
            cur.next = nxt
            cur = cur.next

        return res

print(Solution().deleteDuplicates(ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(3)))))))