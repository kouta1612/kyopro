from typing import Optional

class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def __init__(self):
        self.store = {}

    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head: return None
        if head in self.store: return self.store[head]

        res = Node(head.val)
        self.store[head] = res
        res.next = self.copyRandomList(head.next)
        res.random = self.copyRandomList(head.random)
        return res

print(Solution().copyRandomList(Node(1, Node(2, Node(3, Node(4, Node(5)))))))