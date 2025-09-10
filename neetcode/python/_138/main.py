from typing import Optional

class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def __init__(self):
        self.map = {None: None}

    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None
        if head in self.map:
            return self.map[head]

        copy = Node(head.val)
        self.map[head] = copy
        copy.next = self.copyRandomList(head.next)
        copy.random = self.map[head.random]

        return self.map[head]

print(Solution().copyRandomList(Node(1, Node(2, Node(3, Node(4, Node(5)))))))