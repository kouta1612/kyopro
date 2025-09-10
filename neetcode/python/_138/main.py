from typing import Optional

class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        origin = head

        mp = dict()
        while origin:
            mp[origin] = Node(origin.val, origin.next, origin.random)
            origin = origin.next
        
        origin = head
        cur = mp[origin]
        dummy = Node(0, cur)
        while origin:
            if origin.next in mp:
                cur.next = mp[origin.next]
            if origin.random in mp:
                cur.random = mp[origin.random]
            cur, origin = cur.next, origin.next
        
        return dummy.next


print(Solution().copyRandomList(Node(1, Node(2, Node(3, Node(4, Node(5)))))))