from typing import List, Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        cur = dummy = ListNode(0)
        while True:
            minNode = None
            minIndex = -1
            for i, node in enumerate(lists):
                if not minNode or (node and minNode.val > node.val):
                    minNode = node
                    minIndex = i
            if not minNode: break
            cur.next = ListNode(minNode.val)
            cur = cur.next
            lists[minIndex] = minNode.next
        return dummy.next

print(Solution().mergeKLists([ListNode(1, ListNode(4, ListNode(5))), ListNode(1, ListNode(3, ListNode(4))), ListNode(2, ListNode(6))]))