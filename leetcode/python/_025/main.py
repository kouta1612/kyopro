from types import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        cur = head
        for _ in range(k):
            if not cur: return head
            cur = cur.next
        pre, cur = None, head
        for _ in range(k):
            nxt = cur.next
            cur.next = pre
            pre, cur = cur, nxt
        head.next = self.reverseKGroup(cur, k)
        return pre

print(Solution().reverseKGroup(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), 2))