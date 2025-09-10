from typing import Optional

class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        cur, mp = head, {None: None}

        while cur:
            mp[cur] = Node(cur.val)
            cur = cur.next
        
        cur = head
        while cur:
            copy = mp[cur]
            copy.next = mp[cur.next]
            copy.random = mp[cur.random]
            cur = cur.next

        return mp[head]



print(Solution().copyRandomList(Node(1, Node(2, Node(3, Node(4, Node(5)))))))