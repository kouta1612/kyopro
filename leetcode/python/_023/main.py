from typing import List, Optional
import heapq

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for i, node in enumerate(lists):
            if node: heapq.heappush(heap, (node.val, i, node))

        cur = dummy = ListNode(0)
        while heap:
            v, i, node = heapq.heappop(heap)
            cur.next = node
            cur = cur.next
            if node.next: heapq.heappush(heap, (node.next.val, i, node.next))
        return dummy.next

print(Solution().mergeKLists([ListNode(1, ListNode(4, ListNode(5))), ListNode(1, ListNode(3, ListNode(4))), ListNode(2, ListNode(6))]))