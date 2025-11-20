from typing import List, Optional
import heapq

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        cur = dummy = ListNode()
        while True:
            minNode, mi = None, -1
            for i, node in enumerate(lists):
                if not node: continue
                if not minNode or minNode.val > node.val:
                    minNode = node
                    mi = i
            if not minNode: break
            cur.next = minNode
            cur = cur.next
            lists[mi] = lists[mi].next
        return dummy.next

print(Solution().mergeKLists([ListNode(1, ListNode(4, ListNode(5))), ListNode(1, ListNode(3, ListNode(4))), ListNode(2, ListNode(6))]))