from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pre, cur = ListNode(0, head), head
        now = ListNode()
        dummy = now
        seen = set()

        while cur:
            if cur.val in seen:
                pre.next = cur.next
            else:
                seen.add(cur.val)
                now.next = ListNode(cur.val)
                now = now.next
            pre = cur
            cur = cur.next

        return dummy.next

print(Solution().deleteDuplicates(ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(3)))))))