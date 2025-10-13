from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        cur = head
        num = 0
        while cur:
            cur = cur.next
            num += 1
        pre, cur = ListNode(), head

        move = num-n
        for i in range(move):
            pre = cur
            cur = cur.next

        if cur == head:
            head = head.next
        else:
            pre.next = cur.next
            cur = None

        return head

print(Solution().removeNthFromEnd(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), 2))