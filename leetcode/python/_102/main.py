from typing import Optional, List
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        q = deque([root])
        while q:
            size = len(q)
            vals = []
            for _ in range(size):
                node = q.popleft()
                if node: vals.append(node.val)
                if node and node.left: q.append(node.left)
                if node and node.right: q.append(node.right)
            if vals: res.append(vals)
        return res

print(Solution().levelOrder(None))
print(Solution().levelOrder(TreeNode(1, TreeNode(2), TreeNode(3))))