from typing import List, Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        lists = [node for node in lists if node]
        cur = dummy = ListNode(0)
        while lists:
            pick_i = 0
            for i in range(len(lists)):
                if lists[i].val < lists[pick_i].val: pick_i = i
            cur.next = ListNode(lists[pick_i].val)
            cur = cur.next
            lists[pick_i] = lists[pick_i].next
            if not lists[pick_i]: lists.pop(pick_i)
        return dummy.next

print(Solution().mergeKLists([ListNode(1, ListNode(4, ListNode(5))), ListNode(1, ListNode(3, ListNode(4))), ListNode(2, ListNode(6))]))