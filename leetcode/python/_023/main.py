from typing import List, Optional
from heapq import heappush, heappop

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minHeap = []
        dummy = cur = ListNode()
        for i, node in enumerate(lists):
            if not node: continue
            heappush(minHeap, (node.val, i, node))
        while minHeap:
            v, i, node = heappop(minHeap)
            cur.next = node
            cur = cur.next
            if node.next: heappush(minHeap, (node.next.val, i, node.next))
        return dummy.next

print(Solution().mergeKLists([ListNode(1, ListNode(4, ListNode(5))), ListNode(1, ListNode(3, ListNode(4))), ListNode(2, ListNode(6))]))