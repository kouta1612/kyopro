from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow, fast = head, head.next
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
        
        second = slow.next
        slow.next = None
        pre = None
        while second:
            tmp = second.next
            second.next = pre
            pre, second = second, tmp

        first, second = head, pre
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next, second.next = second, tmp1
            first, second = tmp1, tmp2


print(Solution().reorderList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))))