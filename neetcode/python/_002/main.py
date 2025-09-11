from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode()
        dummy = ListNode(0, head)

        add = 0
        while l1 or l2 or add == 1:
            v1, v2 = 0, 0
            if l1:
                v1 = l1.val
            if l2:
                v2 = l2.val
            sum = v1 + v2 + add
            head.val = sum % 10
            add = sum // 10
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
            if l1 or l2 or add == 1:
                head.next = ListNode()
            head = head.next

        return dummy.next

print(Solution().addTwoNumbers(ListNode(2, ListNode(4, ListNode(3))), ListNode(5, ListNode(6, ListNode(4)))))