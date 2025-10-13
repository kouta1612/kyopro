from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        pre, cur = dummy, head

        while cur and cur.next:
            if cur.val != cur.next.val:
                pre, cur = cur, cur.next
                continue
            while cur and cur.next and cur.val == cur.next.val:
                cur = cur.next
            pre.next = cur.next
            cur = cur.next

        return dummy.next

print(Solution().deleteDuplicates(ListNode(1, ListNode(2, ListNode(3, ListNode(3, ListNode(4, ListNode(4, ListNode(5)))))))))